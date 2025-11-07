#
# Copyright (c) 2025, Focus-5 Consortium Members
#

MAKE = make

all:
	$(MAKE) -C opal-proxy all
	$(MAKE) -C invoker-webportal all

push:
	$(MAKE) -C opal-proxy push
	$(MAKE) -C invoker-webportal push

clean:
	$(MAKE) -C opal-proxy clean
	$(MAKE) -C invoker-webportal clean

purge:
	$(MAKE) -C opal-proxy purge
	$(MAKE) -C invoker-webportal purge
