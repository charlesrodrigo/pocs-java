# archunit-example

Projeto de exemplo de uso de archunit no teste de arquitetura

## Definição de arquitetura

- Regras de Camadas
    - Não podemos importar classes do pacote repository no pacote controller, devemos usar o service para isso
- Regras Gerais Codificação
    - Não podemos usar system.out, system.err para exibir logs
    - Não podemos usar a classe Logger do pacote java util, devemos usar a do pacote org.slf4j
    - Os atributos de logs devem ser private, static e final
    - Não podemos usar exceptions generics
    - Devemos utilizar injeção de dependência via construtor
    - Classes com annotations de service, controller, restcontroller, component, repository devem possuir apenas
      atributos finais
- Regras de Serviços
    - No pacote service deve possuir apenas interfaces
    - No Pacote Impl não pode ter interfaces
    - Classes que estão no pacote impl deve estar anotada com @service
    - Classes que estão anotadas com @Service devem terminar o nome terminando com serviceImpl
    - Classes que estão anotadas com @Service não podem ser públicas
  




