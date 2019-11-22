#!/bin/bash

oc delete dc gateway
oc delete dc dest1

sleep 3

oc apply -f gateway
oc apply -f dest1

#MAX=$1
#
#oc delete dc gateway
#oc delete svc gateway
#oc delete bc gateway
#oc delete is gateway
#oc delete configmap gateway-cfg
#oc delete gateway tracing-gateway-java
#oc delete virtualservice tracing-app-java
#oc delete destinationrule gateway
#
#for i in `seq 1 $MAX`
#do
#  oc delete dc "dest$i"
#  oc delete svc "dest$i"
#  oc delete configmap "dest$i-cfg"
#done
