#!/bin/sh

podman kube down analysis-requester_pod.yml
podman kube play --configmap analysis-requester_config.yml analysis-requester_pod.yml
podman pod logs -f analysis-requester
