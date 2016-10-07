#!/bin/sh

export SBT_OPTS=" \
  -XX:MaxMetaspaceSize=256m \
  -XX:+UseNUMA \
  -XX:+AggressiveOpts \
  -XX:+UseG1GC \
  -XX:+UseCondCardMark \
  -Xms256m \
  -Xmx2g"
sbt
