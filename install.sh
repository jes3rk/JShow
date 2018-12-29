#!bin/bash


sudo add-apt-repository ppa:webupd8team/java

sudo apt update
sudo apt install oracle-java8-installer -y

sudo apt install oracle-java-8-set-default

## install eclipse
wget -P /tmp http://ftp.osuosl.org/pub/eclipse/oomph/epp/2018-12/R/eclipse-inst-linux64.tar.gz
