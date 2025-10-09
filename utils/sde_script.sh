#/bin/sh

#
# Changes needed:
# - Replace the "-subj" argument of the "openssl req" command.
#

openssl genrsa -out sde.key 2048
openssl req -new -key sde.key -subj="/C=UK/ST=Tyne and Wear/O=Arjuna Technologies LTD/OU=Focus5/CN=focus5.home" -out sde.csr
openssl x509 -req -in sde.csr -CA focus-5_ca.crt -CAkey focus-5_ca.key -CAcreateserial -out sde.crt -days 825 -sha256 -extfile sde.v3.ext

rm -f study.csr
