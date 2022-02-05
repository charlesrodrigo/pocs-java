# archunit-example
Ess é projeto de exemplo de uso de archunit no teste de arquitetura 

## Definição de arquitetura
- Não podemos importar classes do pacote repository no pacote controller, devemos usar o service para isso
- Devemos utilizar injeção de dependência via construtor
- Não podemos usar system.out para exibir logs
- Não podemos usar exceptions genericas
- Não podemos usar a classe Logger do pacote java util, devemos usar a do pacote org.slf4j


