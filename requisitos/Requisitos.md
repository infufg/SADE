#Especificação de Requisitos
##Sistema de Avaliação de Docentes - SADE

###Ficha Técnica
####Equipe Responsável
  
1. Eurismar Pires Borges
2. Gabriel Moreira
3. Felipe Kuninory
4. José Sérgio de Souza
5. Julliano Rosa Nascimento 
6. Luiz Henrique Fernandes da Silva 
7. Mauro José Vieira Júnior 
8. Vinícius Maboni 

####Público Alvo
Este manual destina-se às disciplinas de Desenvolvimento de Software para Persistência e Desenvolvimento de Software Concorrente ministradas pelo professor Marcelo Quinta.
  
####1. Introdução
Este documento de especificação de requisitos de software apresenta a descrição do sistema de avaliação de docentes SADE, fornecendo informações necessárias para o projeto e implementação, teste, verificação e validação do software.

#####1.1 Propósito
O propósito deste documento é apresentar os requisitos funcionais e não funcionais, estabelecer o escopo do sistema e o que será abordado no desenvolvimento.
  
#####1.2 Escopo
O aplicativo de software a ser desenvolvido é um sistema de pontuação da avaliação de docentes, SADE. O SADE deve gerenciar, facilitar e permitir que a Universidade Federal de Goiás avalie docentes e departamentos. O aplicativo deve disponibilizar uma API para CRUD para persistir e trabalhar com os dados das avaliações de docentes. O cadastro de professores não entrará no escopo deste software.
  
#####1.3 Definições, Acrônimos e Abreviaturas
| Conceito | Definição |
|----------|-----------|
| SADE | Sistema de Avaliação de Docentes |
| CRUD | Create, retrieve, update, delete. (Criar, recuperar, atualizar e deletar). Operações básicas de persistência de dados.  |
| API | Application Programming Interface (Interface de Programação de Aplicativos) |
| RF | Requisito Funcional  |
| RNF | Requisito Não-funcional  |
| Documento | Documento que descreve as áreas e atividades a serem avaliadas, além da avaliação em si |

####2. Descrição Geral
Com o crescente avanço da tecnologia nos últimos tempos, vê-se a necessidade cada vez maior da inclusão dos processos manuais dentro da praticidade dos meios tecnológicos.  O objetivo geral do SADE é e permitir que a Universidade Federal de Goiás avalie docentes e departamentos. Observa-se a necessidade de um sistema que possa ser atualizado sem modificações drásticas relacionadas com a mudança dos documentos nos quais as avaliações se apoiam, no caso as resoluções.
  
####3. Exigências Específicas
A prioridade dos requisitos está expressa em uma escala de 1 a 5, sendo 1 a menor prioridade e 5 a maior prioridade.

#####3.1 Requisitos Funcionais
| Identificação | Descrição | Prioridade | Detalhes |
|---------------|-----------|-----------|----------|
| RF001 | Cadastro de Área | 5 | Os campos relativos a Área são: Código e Nome. | 
| RF002 | Alterar os dados de uma Área | 3 | O sistema deve permitir a alteração dos dados de uma Área cadastrada, ou seja, a sua atualização. |
| RF003 | Excluir uma Área | 5 | O sistema deve permitir excluir uma Área existente. |
| RF004 | Cadastro de Atividade no sistema | 5 | As atividades são definidas nos documentos, como a [RESOLUÇÃO - CONSUNI Nº 32/2013] [1]. Os campos relativos a Atividade são: Nome, Código, Descrição, Pontuação, Limite de Pontuação, Quantidade, Divisor, Versão e Área. |
| RF005 | Alterar os dados de uma Atividade | 4 | O sistema deve permitir a alteração dos dados de uma Atividade cadastrada, ou seja, a sua atualização. |
| RF006 | Excluir uma Atividade | 5 | O sistema deve permitir excluir uma Atividade existente. |
| RF007 | O sistema deve ser capaz de ler arquivo com extensão ".sade" | 5 | O arquivo ".sade" conterá as informações relacionadas aos docentes e suas atividades realizadas. Sendo assim o principal mecanismo de entrada para processamento do sistema. |
| RF008 | O sistema deve gerar a nota final de cada docente | 5 | O cálculo da nota final será com base nas atividades realizadas por ele, o resultado deve ser obtido aplicando a fórmula descrita no requisito RF009. Essas informações sobre quais atividades o docente realizou estarão em um arquivo ".sade".|
| RF009 | Fórmula para calcular a nota final de um professor| 5 | A fórmula é: Σn, onde n = Notas das atividade, a nota de cada atividade deve ser obtida usando a fórmula do requisito RF010. |
| RF010 | Fórmula para calcular a nota da atividade | 5 | A fórmula é: (p * q / d), onde p = Pontuação, q = Quantidade e d = Divisor. Todas essas informações são da atividade em questão.
| RF011 | O sistema deve mostrar o resultado das avaliações em uma tabela | 5 | A tabela terá as seguintes colunas: "Nome do docente", uma coluna para cada Área estabelecida na Documento e "Nota final". |
| RF012 | Coluna "Nome do docente" da tabela de resultado | 5 | A coluna "Nome do docente"  se refere ao nome do docente avaliado, este nome será informado no arquivo ".sade". |
| RF013 | Colunas referentes às Áreas da tabela de resultado | 5 | As colunas referentes às Áreas correspondem ao somatório da pontuação de todas as atividades realizadas que pertencem aquela Área. |
| RF014 | Coluna "Nota final" da tabela de resultado | 5 | A coluna "Nota final" se refere ao somatório da pontuação de todas as áreas. |
| RF015 | Ordenação da tabela de resultado das avaliações | 3 | O sistema deve ser capaz de ordenar a tabela de resultado das avaliações por "Nome" |
| RF016 | Ordenação da tabela de resultado das avaliações | 3 | O sistema deve ser capaz de ordenar a tabela de resultado das avaliações por "Nota" |
| RF017 | Deve ser possível atualizar as informações de avaliação no sistema. | 5 | A atualização não deve ser realizada por meio de alterações no código fonte, mas sim por meio das informações cadastradas no banco de dados. |
| RF018 | Deve ser disponibilizada uma API para CRUD | 5 | A atualização descrita no RF017 deve ser realizada através de uma API |
| RF019 | Cadastro de Versão de Documento | 5 | Os campos relativos a Versão de Documento são: Código, Periodo Inicial e Período Final. |
| RF020 | Alterar os dados de uma Versão de Documento | 5 | O sistema deve permitir a alteração dos dados de uma Versão de Documento cadastrada, ou seja, a sua atualização. |
| RF021 | Excluir uma Versão de Documento | 5 | O sistema deve permitir excluir uma Versão de Documento existente. |
| RF022 | Lista das Versões de Documento disponíveis| 4 | O sistema deve listar todas as versões dos documentos disponíveis na base de dados. |
| RF023 | Escolha da Versão de Documento | 3 | O sistema deve permitir a escolha da versão do documento que será utilizado para avaliação dos docentes. | 

#####3.2 Requisitos Não-Funcionais
| Identificação | Descrição | Prioridade | Detalhes |
|---------------|-----------|-----------|----------|
| RNF001 | Linguagem de programação | 5 | O sistema deverá ser desenvolvido utilizando a linguagem Java. |
| RNF002 | Banco de dados | 5 | O banco de dados utilizado será o MySQL. |
| RNF003 | Quantidade de Avaliações | 5 | O sistema deve permitir avaliar pelo menos 10 000 docentes por vez. |
| RNF004 | Arquivo | 5 | O sistema deve ser capaz de interpretar arquivos ".sade" |
| RNF005 | API | 5 | A API CRUD deve ser disponibilizada para outros softwares. |
| RNF006 | Quantidade de Atividades | 5 | O sistema deve ser capaz de processar pelo menos 100 atividades para cada docente. |

####4.Informações de Suporte
#####4.1 Apêndices
#####4.2 Referências
[RESOLUÇÃO - CONSUNI Nº 32/2013] [1]

[1]: http://www.adufg.org.br/dados/editor3/file/Resolucao_CONSUNI_2013_0032.pdf "RESOLUÇÃO - CONSUNI Nº 32/2013" 
