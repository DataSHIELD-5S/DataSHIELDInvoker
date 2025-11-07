#
# Copyright (c) 2025, Focus-5 Consortium Members
#

include ../settings.mk
include ../build.mk

QUARKUS = quarkus
MVN     = mvn
PODMAN  = podman

# IMAGE_TAG from settings.mk
IMAGE_NAME = $(IMAGE_REPO)/opal-proxy
# IMAGE_TAG from settings.mk

all:
	$(QUARKUS) build
	$(PODMAN) build -t $(IMAGE_NAME):$(IMAGE_TAG) -f src/main/docker/Dockerfile.jvm .

push: all
	$(PODMAN) image push $(IMAGE_NAME):$(IMAGE_TAG)

clean:
	$(MVN) clean

purge: clean
	$(PODMAN) $(POCMAN_IMAGE_RM) $(IMAGE_NAME):$(IMAGE_TAG)
