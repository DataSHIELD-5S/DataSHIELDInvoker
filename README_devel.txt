HTTPS network traffic dumping
-----------------------------

ncat -l --ssl --ssl-cert=datashield-invoker/server.crt --ssl-key=datashield-invoker/server.key focus5 8443
