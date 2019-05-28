#!/usr/bin/env bash
port=8080
env=${1:-prod}
count=${2:-1}
server="template"

echo "**************************************************************************************"
echo "Will start server at Environment [${env}] Instance Count [${count}]"
mkdir -p ../log

for (( i = 0; i < $count; i++ ))
do
    echo "Start ${server} server instance [$((i+1))] for [$env] at port [$port]..."
    outfile="../log/process_$((i+1))/process.log"
    if [[ -f ${outfile} ]]
    then
        rm ${outfile}
    fi
    mkdir -p ../log/process_$((i+1)) && touch ${outfile}
    java -jar ../lib/${server}*.jar --spring.config.location=file:../env/ --spring.profiles.active=${env} --logging.path=../log/process_$((i+1)) --server.port=${port}>>${outfile} 2>&1 &((port = port +1))
done

for((i=0;i<10;i++))
do
    echo -ne "."
    sleep 1
done

cat ../log/process_*/process.log

echo "**************************************************************************************"
