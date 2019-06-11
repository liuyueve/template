#!/usr/bin/env bash
#proce=$(sed -n '1p' application.pid)
#kill -9 ${proce}
awk '{print $0}' application*.pid | xargs kill -15
rm -rf application*.pid
