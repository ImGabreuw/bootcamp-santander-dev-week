# Santander Dev Week

### API

* API = (A)pplication (P)rogramming (I)nterface
* Conjunto de rotinas e padrões estabelecidos e documentados por uma determinada aplicação

### Rest

* REST = (R)epresentation (S)tate (T)ransfer
* Definição de caracterísicas fundamentais para a construção de aplicações Web seguindo boas práticas

### Protocolo HTTP

* Métodos
  
    * **GET** = Obter um recurso
    * **POST** = Criar um recurso
    * **PUT** = Atualizar um recurso
    * **DELETE** = Remover um recurso
    
* Códigos de resposta

    * **1XX** = Informações gerais
    * **2XX** = Sucesso
    * **3XX** = Redirecionamento
    * **4XX** = Erros relacionados as tratamento dos dados no servidor
    * **5XX** = Erro no servidor
    
### JSON

* JSON = (J)ava(S)cript (O)bject (N)otation
* Um formato leve de troca de informações / dados entre sistemas
* Exemplo
  
    ```json
    {
      "firstName": "Jonathan",
      "lastName": "Freeman",
      "loginCount": 4,
      "isWriter": true,
      "workWith": ["Spantree Technology Group", "InfoWorld"],
      "pets": {
        "name": "Lilly",
        "type": "Raccon"
      }   
    }
    ```
  
### Docker

* Criação de um container (banco de dados)

  ```bash
  $ docker run --name db_bootcamp -e POSTGRES_PASSWORD=5504 -d -p 5432:5432 postgres
  ```
  
  * **run** = criar e subir o _container_
  * **--name** = nome da imagem
  * **-e** = variáveis de ambientes (`POSTGRES_PASSWORD` é a senha para acessar o banco de dados)
  * **-d** = rodar em segundo plano, ou seja, mesmo se o terminal for fechado, o serviço continuará rodando
  * **5432:5432** = forma para acessar o _cantainer_ (`porta_externa:porta_interna`)
    > OBS: a porta padrão do PostgreSQL é `5432`
  * **postgres** = imagem que subirá para o _container_
    > Para ver as imagens disponíveis, acesse o [Docker HUB](https://hub.docker.com/)
    
* Listagem dos _container_ em execução

  ```shell
  $ docker container ps
  ```

* Listagem de todos os _container_

  ```shell
  $ docker container ps -a
  ```

* Listagem de todos as _image_

  ```shell
  $ docker image ls
  ```

* Interromper um _container_

  ```shell
  $ docker container stop <nome_do_container>
  ```

* Iniciar um _container_

  ```shell
  $ docker container start <nome_do_container>
  ```

* Visualizar as logs de um _container_

  ```shell
  $ docker container logs <nome_do_container>
  ```

* Visualizar as informações de um _container_

  ```shell
  $ docker container inspect <nome_do_container>
  ```

* Remover um _container_

  ```shell
  $ docker container rm <nome_do_container>
  ```

* Remover uma _image_

  ```shell
  $ docker image rm <nome_da_image>
  ```

* Visualizar as informações de consumo de recursos da máquina

  ```shell
  $ docker stats
  ```
  
### DBeaver

* DBeaver é um aplicativo de software cliente SQL e uma ferramenta de administração de banco de dados
* Site: [clique aqui](https://dbeaver.io/)

### Banco de dados

* Criação da tabela `tb_stock`
  
  ```roomsql
  CREATE TABLE public.tb_stock (
    id NUMERIC(9) NOT NULL,
    "date" DATE NOT NULL,
    "name" VARCHAR(100) NOT NULL,
    price NUMERIC(8,2) NOT NULL,
    variation NUMERIC(5,2) NOT NULL,
    CONSTRAINT tb_stock_pkey PRIMARY KEY (id)
  );
  ```
  
    * `NUMERIC(8,2)`
      * Aceita valores positivos e negativos
      * `5` = Número máxima de dígitos
      * `2` = Número de casas decimais
      * Exemplo: `999,99`