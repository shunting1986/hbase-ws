hbase-root := /home/shunting/work/ubuntu-contents/hadoop/hbase-0.94.4/extracted
cp := $(wildcard classes $(hbase-root)/*.jar $(hbase-root)/lib/*.jar $(hbase-root)/conf)
empty :=
space := $(empty) $(empty)
cp := $(subst $(space),:,$(cp))

run:
	@echo + compile
	@javac -cp $(cp) -d classes sample/Main.java
	@echo + run
	@java -cp $(cp) sample.Main

server:
	@echo + start server
	@java -cp $(cp) org.apache.hadoop.hbase.master.HMaster start

rest:
	@echo + start rest 
	@java -cp $(cp) org.apache.hadoop.hbase.rest.Main start

myrest-src := $(shell find /home/shunting/work/ubuntu-contents/hadoop/hbase-0.94.4/shunting-code/org/apache/hadoop/hbase/rest/ -name *.java)

build-myrest:
	@echo + build my rest server
	@javac -cp $(cp) -d classes $(myrest-src)
	
