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