ikvmc -target:library NecessaryLib/ant-1.7.1.jar -out:DLLs/ant-1.7.1.dll
ikvmc -target:library NecessaryLib/commons-logging-1.1.1.jar -out:DLLs/commons-logging-1.1.1.dll
ikvmc -target:library DTRules2NLP/dist/lib/JFlex.jar -out:DLLs/JFlex.dll

ikvmc -target:library DTRules2NLP/dist/lib/java-cup-10k.jar -r:DLLs/ant-1.7.1.dll -out:DLLs/java-cup-10k.dll
ikvmc -target:library DTRules2NLP/dist/lib/poi-3.7.jar -r:DLLs/commons-logging-1.1.1.dll -out:DLLs/poi-3.7.dll

ikvmc -target:library DTRules2NLP/dist/DTRules2NLP.jar -out:DLLs/DTRules2NLP.dll -r:DLLs/JFlex.dll -r:DLLs/java-cup-10k.dll  -r:DLLs/poi-3.7.dll
