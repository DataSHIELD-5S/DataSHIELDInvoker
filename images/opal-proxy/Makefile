#
# Copyright (c) 2025, Focus-5 Consortium Members
#

include ../settings.mk
include ../build.mk

QUARKUS   = quarkus
MVN       = mvn
BUILD_CMD = podman
PUSH_CMD  = minikube
PURGE_CMD = podman

# IMAGE_TAG from settings.mk
IMAGE_NAME = $(IMAGE_REPO)/opal-proxy
# IMAGE_TAG from settings.mk

all:
	$(QUARKUS) build
	$(BUILD_CMD) build -t $(IMAGE_NAME):$(IMAGE_TAG) -f src/main/docker/Dockerfile.jvm .

push: all
	$(PUSH_CMD) image push $(IMAGE_NAME):$(IMAGE_TAG)

clean:
	$(MVN) clean

purge: clean
	$(PURGE_CMD) $(POCMAN_IMAGE_RM) $(IMAGE_NAME):$(IMAGE_TAG)
