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
O aplicativo de software a ser desenvolvido é um sistema de avaliação de docentes, SADE. O SADE deve gerenciar, facilitar e permitir que a Universidade Federal de Goiás avalie docentes e departamentos.
  
#####1.3 Definições, Acrônimos e Abreviaturas
| Conceito | Definição |
|----------|-----------|
| SADE | Sistema de Avaliação de Docentes |
| CAD | Comissão de Avaliação Docente  |
| RF | Requisito Funcional  |
| RNF | Requisito Não-funcional  |

####2. Descrição Geral
Com o crescente avanço da tecnologia nos últimos tempos, vê-se a necessidade cada vez maior da inclusão dos processos manuais dentro da praticidade dos meios tecnológicos.  O objetivo geral do SADE é e permitir que a Universidade Federal de Goiás avalie docentes e departamentos. Observa-se a necessidade de um sistema que possa ser atualizado sem modificações drásticas relacionadas com a mudança das resoluções nas quais as avaliações se apoiam.
  
####3. Exigências Específicas
#####3.1 Requisitos Funcionais
| Identificação | Descrição | Prioridade | Detalhes |
|---------------|-----------|-----------|----------|
| RF001 |  Cadastro de docente no sistema | Essencial | O cadastro de docente depende das informações do Departamento Pessoal. |
| RF002 | Cadastro de atividades no sistema | Essencial | As atividades são definidas na [RESOLUÇÃO - CONSUNI Nº 32/2013] [1]. |
| RF003 | Cadastro de avaliações no sistema | Essencial |  O cadastro de avaliações... |

#####3.2 Requisitos Não-Funcionais
| Identificação | Descrição | Prioridade | Detalhes |
|---------------|-----------|-----------|----------|
| RNF001 | Deve ser possível atualizar as informações de avaliação no sistema. | Essencial | A atualização não deve ser realizada por meio de alterações no código fonte, mas sim por meio das informações cadastradas no banco de dados. |

####4.Informações de Suporte
#####4.1 Apêndices
#####4.2 Referências
[RESOLUÇÃO - CONSUNI Nº 32/2013] [1]

[1]: http://www.adufg.org.br/dados/editor3/file/Resolucao_CONSUNI_2013_0032.pdf "RESOLUÇÃO - CONSUNI Nº 32/2013" 