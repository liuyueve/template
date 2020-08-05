#!/usr/bin/env bash
port=8080
env=${1:-prod}
count=${2:-1}
server="template"

echo "**************************************************************************************"
echo "Will start server at Environment [${env}] Instance Count [${count}]"
mkdir -p ../log
mkdir -p pid

flag_arr=()

for (( i = 0; i < $count; i++ ))
do
    flag_arr[i]=${port}
    echo "Start ${server} server instance [$((i+1))] for [$env] at port [$port]..."
    outfile="../log/process_$((i+1))/process.log"
    if [[ -f ${outfile} ]]
    then
        rm ${outfile}
    fi
    mkdir -p ../log/process_$((i+1)) && touch ${outfile}
    java -jar ../lib/${server}*.jar --spring.config.location=file:../env/ --spring.profiles.active=${env} --logging.path=../log/process_$((i+1)) --server.port=${port} --spring.pid.file=pid/pid_${i}.pid>>${outfile} 2>&1 &((port = port +1))
done

start=0
fail=0

while [[ $((${start}+${fail})) < ${count} ]]
do
    for (( i = 0; i < $count; i++ ))
    do
        if [[ ${flag_arr[i]} == 0 ]]
        then
            continue
        fi
        result=`grep -c 'successssssssss' ../log/process_$((i+1))/process.log`
        if [[ ${result} == 1 ]]
        then
            echo "-------------------------------------------------------"
            echo "server instance at port [${flag_arr[i]}] start success!"
            ((start++))
            flag_arr[i]=0
            cat ../log/process_$((i+1))/process.log
            echo "-------------------------------------------------------"
        fi
        result=`grep -c 'failllllllllll' ../log/process_$((i+1))/process.log`
        if [[ ${result} == 1 ]]
        then
            echo "-------------------------------------------------------"
            echo "server instance at port [${flag_arr[i]}] start failed!"
            ((fail++))
            flag_arr[i]=0
            cat ../log/process_$((i+1))/process.log
            echo "-------------------------------------------------------"
        fi
    done
    echo -ne '.'
    sleep 1
done
echo "instance start success [${start}] failed [${fail}]"
echo "**************************************************************************************"
