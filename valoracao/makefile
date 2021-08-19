#makefile para linux

FLAGS_C = -d bin/ -cp 'lib/*' -sourcepath 'src/'
#FLAGS_C -> para compilar (colocamos em uma "variável" para não precisar reescrever)
#-d -> diretório de output
#-sourcepath -> onde estão os arquivos .java do projeto
#-cp (classpath)->bibliotecas terceiras (.jar)

FLAGS_R = -cp 'bin/:lib'
#FLAGS_R -> para executar
#bin -> onde irão ficar os binários dos arquivos do projet0
#lib -> onde irão ficar os binários dos arquivos das bibliotecas terceiras

all: comp run

comp:
	javac $(FLAGS_C) src/valoracao/Main.java
run:
	java $(FLAGS_R) valoracao/Main

clean: 
	rm -r bin/valoracao/*