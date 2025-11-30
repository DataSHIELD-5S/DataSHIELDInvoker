#
# Copyright (c) 2025, Focus-5 Consortium Members
#

#
# In IP4 only environment need "export NODE_OPTIONS=--dns-result-order=ipv4first" 
#

include ../settings.mk
include ../build.mk

RMDIR     = rm -rf
NPM       = npm
NG        = ng
PODMAN    = podman
BUILD_CMD = podman
PUSH_CMD  = minikube
PURGE_CMD = podman

IMAGE_NAME = $(IMAGE_REPO)/invoker-webportal
# IMAGE_TAG from settings.mk

all: dist
	$(BUILD_CMD) build -t $(IMAGE_NAME):$(IMAGE_TAG) -f Containerfile .

push: all
	$(PUSH_CMD) image push $(IMAGE_NAME):$(IMAGE_TAG)

dist: node_modules
	$(NG) build

node_modules:
	$(NPM) install

clean:
	$(RMDIR) dist

purge: clean
	$(RMDIR) node_modules
	$(NG) cache clean
	$(PURGE_CMD) $(POCMAN_IMAGE_RM) $(IMAGE_NAME):$(IMAGE_TAG)
