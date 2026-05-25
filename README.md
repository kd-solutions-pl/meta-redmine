# meta-redmine
Yocto layer for packaging Redmine for a read-only target image.

Note: It should work on any rootfs with `/data` directory writable for redmine user.
## Build
### Standard yocto build
Standard yocto build requires adding meta-redmine layer to your <build_dir>conf/bblayers.conf, `redmine` and `postgres` packages to your dedicated image. Please note that the idea is to have meta-redmine self-contained what means it will provide `redmine` and *ONLY* `redmine` functionality in future.
### Albertow build
See build instructions in [albertow](https://github.com/kd-solutions-pl/albertow) repo
## Redmine SSL certificates
Redmine is configured to run [Puma](https://github.com/puma/puma/) server and SSL using files stored on the target
data partition:
```
/data/redmine/config/ssl/redmine.crt
/data/redmine/config/ssl/redmine.key
```
The recipe does not create certificates on the target. Generate certificates
on the host with the `create-ssl-certs` helper script in this layer, then copy the generated
server certificate and key to the target. <u>If you have your own PKI infrastructure use
your own solution.</u>
### Generate a Root CA and Redmine certificate
Create a local Root CA and a Redmine server certificate for localhost:
```
scripts/create-ssl-certs \
  --ca-dir ./redmine-root-ca \
  --ca-cn "Redmine local Root CA" \
  --out-dir ./redmine-ssl \
  --cn localhost \
  --dns localhost \
  --ip 127.0.0.1
```
This creates:
```
./redmine-root-ca/root-ca.crt
./redmine-root-ca/root-ca.key
./redmine-ssl/redmine.crt
./redmine-ssl/redmine.key
```
Keep `root-ca.key` private. Import `root-ca.crt` into Firefox. Upload only
`redmine.crt` and `redmine.key` to the target.
### Import the Root CA in Firefox
1. Open Firefox settings.
2. Go to `Privacy & Security`.
3. Scroll to `Certificates`.
4. Click `View Certificates`.
5. Select the `Authorities` tab.
6. Click `Import`.
7. Select `root-ca.crt`.
8. Enable `Trust this CA to identify websites`.
9. Confirm the dialog.

Firefox trusts certificates signed by this Root CA only when the URL matches a
DNS or IP subject alternative name in the Redmine server certificate.
## Running redmine-image with QEMU
Note: Instruction is aplicable for `redmine-image-albertow`.

Use [run-qemu](https://github.com/kd-solutions-pl/albertow/meta-albertow/scripts/run-qemu) to boot a built image with a read-only
squashfs root filesystem and a persistent ext4 data disk mounted by the image
at `/data`. Read instructions how to run generated images with QEMU under [albertow](https://github.com/kd-solutions-pl/albertow) repo
### Update certificates on the target
Copy the generated server certificate and key to the target data partition:
```
install -d -m 0755 /data/redmine/config/ssl
install -m 0644 redmine.crt /data/redmine/config/ssl/redmine.crt
install -m 0600 redmine.key /data/redmine/config/ssl/redmine.key
chown redmine:redmine /data/redmine/config/ssl/redmine.crt /data/redmine/config/ssl/redmine.key
```
Restart Redmine:
```
systemctl restart redmine.service
```
Then open Redmine using a URL covered by the certificate, for example:
```
https://localhost:3000
https://redmine.local:3000
```
## Other usage examples for create-ssl-certs script
If the Redmine address changes, generate a new server certificate with all
names and IP addresses that Firefox may use. Reuse the same Root CA directory
so Firefox does not need a new CA import:
When `--ca-dir` already contains `root-ca.crt` and `root-ca.key`, the script
reuses that Root CA. Do not pass `--ca-cn` unless you are creating or replacing
the Root CA.

Minimum command for a different DNS name, assuming `--ca-dir` already exists
```
scripts/create-ssl-certs \
  --ca-dir ./redmine-root-ca \
  --out-dir ./redmine-ssl-redmine-local \
  --cn redmine.local \
  --dns redmine.local
```
Minimum command for a different IP address, assuming `--ca-dir` already exists:
```
scripts/create-ssl-certs \
  --ca-dir ./redmine-root-ca \
  --out-dir ./redmine-ssl-192-168-7-2 \
  --cn 192.168.7.2 \
  --ip 192.168.7.2
```
Minimum command for another server with both a DNS name and an IP address:
```
scripts/create-ssl-certs \
  --ca-dir ./redmine-root-ca \
  --out-dir ./redmine-ssl-server2 \
  --cn server2.local \
  --dns server2.local \
  --ip 192.168.7.3
```
Include every name or address used in Firefox. For example:
```
scripts/create-ssl-certs \
  --ca-dir ./redmine-root-ca \
  --out-dir ./redmine-ssl-new \
  --cn redmine.local \
  --dns redmine.local \
  --dns localhost \
  --ip 127.0.0.1 \
  --ip 192.168.7.2
```
Use `--force-server` if the output directory already contains
`redmine.crt` or `redmine.key`:
```
scripts/create-ssl-certs \
  --ca-dir ./redmine-root-ca \
  --out-dir ./redmine-ssl-new \
  --force-server \
  --cn redmine.local \
  --dns redmine.local \
  --ip 192.168.7.2
```
Use `--force-ca` only when you intentionally want to replace the Root CA. If
you replace the Root CA, import the new `root-ca.crt` into Firefox again.
