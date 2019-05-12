#!/usr/bin/env bash
port=9091
env="prod"
count=1

if [[ x$1 != "x" ]];
then
    env=$1;
fi

if [[ y$2 != "y" ]];
then
    count=$2;
fi

echo "--------------------------------------------------------------------------------"
echo "Will start server at Environment [${env}] Instance Count [${count}]"
mkdir -p ../log

for (( i = 0; i < $count; i++ ))
do
    echo "Start server instance [$((i+1))] for [$env] at port [$port]..."
    outfile="../log/process_$((i+1))/process.log"
    if [[ -f $outfile ]]
    then
        rm $outfile
    fi
    mkdir -p ../log/process_$((i+1)) && touch $outfile
    java -jar ../lib/template*.jar --spring.config.location=../env --spring.profiles.active=${env} --logging.path=../log/process_$((i+1)) >>$outfile 2>&1 &((port = port +1))
done

echo "--------------------------------------------------------------------------------"
