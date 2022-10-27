compile() {
	cf=$(stat --printf '%Y\n' ${1}.class)
	sf=$(stat --printf '%Y\n' ${1}.java)

	if [ $cf -lt $sf ]
	then
		javac ${1}.java
	fi
}
run(){
	java $1 < $2
}
execute(){
	compile $1
	run $1 $2
}
# execution $1 $2
