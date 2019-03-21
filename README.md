# PokemonApp

Este projeto foi dividido em pacotes para uma melhor organização do código, os pacotes são os seguintes:

**Activity:** Guarda todas as atividades da aplicação.
- MainActivity.java
- PokemonsActivity.java
- PokemonDetailsActivity.java

**Adapter:** Guarda adaptadores para listas e grids que são utilizados nos layouts.
- AbilityGridAdapter.java
- PokemonListAdapter.java
- TypeListAdapter.java

**Model:** Guarda a modelagem das classes utilizadas na aplicação.
- Ability.java
- Pokemon.java
- Sprite.java
- Type.java

**Return:** Guarda os retorno das requisições feitas pelo Retrofit.
- AbilitiesReturn.java
- PokemonReturn.java
- PokemonSecondReturn.java
- PokemonThirdReturn.java
- TypeReturn.java

**Style:** Guarda as classes relacionadas ao estilo da aplicação.
- PokemonListStyle
- TypeStyle

**Util:** Guarda a configuração do Retrofit e o serviço de requisições.
- PokemonService
- RetrofitConfig

## Algumas bibliotecas/recursos utilizadas:

- **Retrofit** - Biblioteca utilizada para realizar as requisições a PokeAPI, esta biblioteca facilita a comunicação entre a aplicação e a API.
- **Jackson** - Biblioteca de tratamento de arquivos JSON, para a conversão destes arquivos para objetos.
- As imagens utilizadas na tela inicial para os tipos, foram retiradas do site https://pokemongo.fandom.com/wiki/Types.
