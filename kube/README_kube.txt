Start Pod
---------

podman kube play --configmap analysis-requester_config.yml analysis-requester_pod.yml

Shutdown pod
------------

podman kube down analysis-requester_pod.yml

Total Podman reset
------------------

podman system reset
