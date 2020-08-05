#!/usr/bin/env bash

echo "**************************************************************************************"
count=`ls pid|grep -c 'pid'`
start=`date +%s`

echo "application running count is : [${count}]"

pid_arr=()

for (( i = 0; i < $count; i++ ))
do
    pid_arr[i]=`cat pid/pid_${i}.pid`
done

for (( i = 0; i < $count; i++ ))
do
    echo "execute kill -15 ${pid_arr[i]}"
    kill -15 ${pid_arr[i]}
done

closed=0
now=`date +%s`

while [[ ${closed} < ${count} ]]
do
    for (( i = 0; i < $count; i++ ))
    do

        if [[ ${pid_arr[i]} == -1 ]]
        then
            continue
        fi

        result=`ps -p ${pid_arr[i]} | awk '{print \$1}'`
        if [[ ${result} == "PID" ]]
        then
            echo "application ${pid_arr[i]} has been stopped!"
            pid_arr[i]=-1
            ((closed++))
            continue
        fi

        timeCost=$(($now-$start))
        if [[ ${timeCost} > 60 ]]
        then
            echo "time cost more than 60 seconds,will execute kill -9 force stop!"
            kill -9 ${pid_arr[i]}
            ((closed++))
            pid_arr[i]=-1
        fi

    done
    sleep 1
    now=`date +%s`
done

rm -rf pid/
echo "**************************************************************************************"