# projeto2020a_A_Lexico

Um analisador léxico para a linguagem LMS como requisito para a matéria Teoria das Linguagens Formais na UNISUL.

### ⚙️ Scripts

**Necessário ter Java 11**

Execução: `./gradlew run`

Distribuição: `./gradlew build`

### 📘 Especificação da linguagem LMS

#### Símbolos especiais

`.` `:` `,` `;` `..` `(` `)` `[` `]`

#### Palavras reservadas

`AND` `ARRAY` `BEGIN` `CALL` `CASE` `CONST` `DO` `ELSE` `END` `FOR` `GOTO` `IF` `INTEGER` `LABEL` `NOT` `OF` `OR` `PROCEDURE` `PROGRAM` `READLN` `REPEAT` `THEN` `TO` `UNTIL` `VAR` `WHILE` `WRITELN`

- 📝 Case-insensitive

#### Identificadores

Conjunto de caractéres alfanuméricos com no **máximo 30 caractéres**. O primeiro caractére deve ser uma letra.

#### Números inteiros

Conjunto de números inteiros, entre `-32767` e `32767`.

#### Literais

Sequência de caractéres delimitada por `"`, com no **máximo 255 caractéres**.

#### Operadores

1. `-` menos unário
2. `NOT` operador de negação
3. `*` `/` operadores de multiplicação/divisão
4. `AND` `OR` operadores lógicos
5. `+` `-` operador de adição/subtração
6. `<` `>` `=` `<=` `>=` `<>` operadores relacionais

#### Comentários

Conjunto de caractéres delimitado por `(*` e `*)`.

#### Delimitadores

Qualquer token pode ser separado por espaço(s) em branco, fim de arquivo ou comentário(s).

### 📋 Tabela de símbolos da linguagem LMS

| Código | Símbolo    | Descrição                         |
| ------ | ---------- | --------------------------------- |
| 1      | PROGRAM    | Palavra reservada                 |
| 2      | LABEL      | Palavra reservada                 |
| 3      | CONST      | Palavra reservada                 |
| 4      | VAR        | Palavra reservada                 |
| 5      | PROCEDURE  | Palavra reservada                 |
| 6      | BEGIN      | Palavra reservada                 |
| 7      | END        | Palavra reservada                 |
| 8      | INTEGER    | Palavra reservada                 |
| 9      | ARRAY      | Palavra reservada                 |
| 10     | OF         | Palavra reservada                 |
| 11     | CALL       | Palavra reservada                 |
| 12     | GOTO       | Palavra reservada                 |
| 13     | IF         | Palavra reservada                 |
| 14     | THEN       | Palavra reservada                 |
| 15     | ELSE       | Palavra reservada                 |
| 16     | WHILE      | Palavra reservada                 |
| 17     | DO         | Palavra reservada                 |
| 18     | REPEAT     | Palavra reservada                 |
| 19     | UNTIL      | Palavra reservada                 |
| 20     | READLN     | Palavra reservada                 |
| 21     | WRITELN    | Palavra reservada                 |
| 22     | OR         | Operador de negação               |
| 23     | AND        | Operador lógico                   |
| 24     | NOT        | Operador lógico                   |
| 25     | IDENTIFIER | Identificador                     |
| 26     | NUMBER     | Número inteiro                    |
| 27     | FOR        | Palavra reservada                 |
| 28     | TO         | Palavra reservada                 |
| 29     | CASE       | Palavra reservada                 |
| 30     | +          | Operador de adição/subtração      |
| 31     | -          | Operador de adição/subtração      |
| 32     | \*         | Operador de multiplicação/divisão |
| 33     | /          | Operador de multiplicação/divisão |
| 34     | [          | Símbolo especial                  |
| 35     | ]          | Símbolo especial                  |
| 36     | (          | Símbolo especial                  |
| 37     | )          | Símbolo especial                  |
| 38     | :=         | Atribuição                        |
| 39     | :          | Símbolo especial                  |
| 40     | =          | Operador relacional               |
| 41     | >          | Operador relacional               |
| 42     | >=         | Operador relacional               |
| 43     | <          | Operador relacional               |
| 44     | <=         | Operador relacional               |
| 45     | <>         | Operador relacional               |
| 46     | ,          | Símbolo especial                  |
| 47     | ;          | Símbolo especial                  |
| 48     | LITERAL    | Literal                           |
| 49     | .          | Símbolo especial                  |
| 50     | ..         | Símbolo especial                  |
| 51     | \$         | Fim de arquivo                    |

## Licença

Este projeto está sobre a [licença MIT](/LICENSE).
