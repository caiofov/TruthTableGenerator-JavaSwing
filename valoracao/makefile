#makefile para linux

FLAGS_C = -d bin/ -cp 'lib/*' -sourcepath 'src/'
#FLAGS_C -> para compilar (colocamos em uma "variável" para não precisar reescrever)
#-d -> diretório de output
#-sourcepath -> onde estão os arquivos .java do projeto
#-cp (classpath)->bibliotecas terceiras (.jar)

FLAGS_R = -cp 'bin/:lib'
#FLAGS_R -> para executar
#bin -> onde irão ficar os binários dos arquivos do projeot
#lib -> onde irão ficar os binários dos arquivos das bibliotecas terceiras

all:
	javac $(FLAGS_C) src/Main.java
	java $(FLAGS_R) Main
c:
	javac $(FLAGS_C) src/Main.java
r:
	java $(FLAGS_R) Main

clean: 
	rm **/*.class