Start Pods
----------

podman kube play --configmap analysis-responder_config.yml analysis-responder_pod.yml
podman kube play --configmap analysis-requester_config.yml analysis-requester_pod.yml

Logs of Pods
------------

podman pod logs -f analysis-responder
podman pod logs -f analysis-requester

Shutdown Pods
-------------

podman kube down analysis-responder_pod.yml
podman kube down analysis-requester_pod.yml

Total Podman reset
------------------

podman system reset
