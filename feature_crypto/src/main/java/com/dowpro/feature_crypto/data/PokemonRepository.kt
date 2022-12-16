package com.dowpro.feature_crypto.data


import com.dowpro.feature_crypto.AbilitiesQuery
import com.dowpro.feature_crypto.PokemonsQuery
import com.dowpro.library_graphql.GraphQLClientProvider
import com.dowpro.library_graphql.GraphQLException

interface PokemonRepository {
    suspend fun getPokemons(): List<PokemonsQuery.Pokemon>
    suspend fun getAbilities(): List<AbilitiesQuery.Ability>
}

class PokemonRepositoryImpl(private val graphQLClientProvider: GraphQLClientProvider) :
    PokemonRepository {

    override suspend fun getPokemons(): List<PokemonsQuery.Pokemon> {
        val graphQLReply = graphQLClientProvider.getGraphQLClient().query(PokemonsQuery())
        if (graphQLReply.hasData) {
            return graphQLReply.data?.pokemons?.pokemon?: emptyList()
        } else {
            throw GraphQLException(error = graphQLReply.throwable)
        }
    }

    override suspend fun getAbilities(): List<AbilitiesQuery.Ability> {
        val graphQLReply = graphQLClientProvider.getGraphQLClient().query(AbilitiesQuery())
        if (graphQLReply.hasData) {
            return graphQLReply.data?.abilities?.ability?: emptyList()
        } else {
            throw GraphQLException(error = graphQLReply.throwable)
        }
    }
}
