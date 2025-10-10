Start Pod
---------

podman kube play --configmap datashield-invoker_config.yml datashield-invoker_pod.yml

Shutdown pod
------------

podman kube down datashield-invoker_pod.yml

Total Podman reset
------------------

podman system reset
