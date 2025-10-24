#
# Copyright (c) 2025, Focus-5 Consortium Members
#

MAKE = make

all:
	$(MAKE) -C datashield-invoker all
	$(MAKE) -C direct-proxy all
	$(MAKE) -C invoker-webproxy all

push:
	$(MAKE) -C datashield-invoker push
	$(MAKE) -C direct-proxy push
	$(MAKE) -C invoker-webproxy push

clean:
	$(MAKE) -C datashield-invoker clean
	$(MAKE) -C direct-proxy clean
	$(MAKE) -C invoker-webproxy clean

purge:
	$(MAKE) -C datashield-invoker purge
	$(MAKE) -C direct-proxy purge
	$(MAKE) -C invoker-webproxy purge
