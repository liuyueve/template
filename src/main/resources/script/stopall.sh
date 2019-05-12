#!/usr/bin/env bash
proce=$(sed -n '1p' application.pid)
kill -9 ${proce}
rm -rf application.pid
