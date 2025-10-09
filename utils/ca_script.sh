#/bin/sh

#
# Changes needed:
# - Replace the "-subj" argument of the "openssl req" command.
#

openssl genrsa -out focus-5_ca.key 2048
openssl req -x509 -new -nodes -key focus-5_ca.key -sha256 -days 1825 -subj="/C=UK/ST=Tyne and Wear/O=Arjuna Technologies LTD/OU=Focus-5 Devel/CN=Arjuna Focus-5 CA" -out focus-5_ca.crt
