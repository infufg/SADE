#SADE - Implantação da API de persistência
Essa documentação tem como objetivo informar sobre o ambiente necessário para a implantação da API de persistência.
##Funcionalidades
* Cadastro de áreas.
* Alteração de dados de uma área.
* Exclusão de Áreas.
* Cadastramento de atividades no sistema.
* Alteração de dados de atividades.
* Exclusão de atividades.
* Leitura de arquivos com extensão ".sade".
* Geração de nota final de docente.
* Calculo de nota das atividades.
* Visualização de resultados das avaliações em uma tabela.
* Atualização de informações de avaliações no sistema.
* Cadastramento de Versões de Documentos.
* Alteração de dados de uma versão de Documento.
* Exclusão de versão de documentos.
* Listagem com versões de documentos disponíveis.
* Escolha de Versão do documento.

##Visão de implantação
* Banco de dados MySQL versão 5.6.19
  * Download disponível em: http://dev.mysql.com/downloads/mysql/
* Maquina virtual Java
  * Download disponível em: http://www.oracle.com/technetwork/pt/java/javase/downloads/jre7-downloads-1880261.html

##Configuração
1. Apos instalar o MySQL, crie um banco de dados.
2. Abra o arquivo "persistence.xml" e altere o valor da linha 9 (property name="javax.persistence.jdbc.url" value="Coloque aqui o local de seu banco") colocando a localização de seu banco de dados.

