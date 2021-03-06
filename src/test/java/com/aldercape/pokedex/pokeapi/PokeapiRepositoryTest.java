package com.aldercape.pokedex.pokeapi;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.web.client.RestTemplate;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class PokeapiRepositoryTest {

    @Test
    public void testGetPokemonByName() {
        var client = mock(RestTemplate.class);
        when(
                client.getForObject(
                        eq("https://pokeapi.co/api/v2/pokemon-species/mewtwo"),
                        eq(String.class)))
                .thenReturn(mewtwoJson);

        var repo = new PokeapiRepository(client);
        var result = repo.getPokemonByName("mewtwo");

        assertEquals("mewtwo", result.name());
        assertEquals("It was created by a scientist after years of horrific gene splicing and DNA engineering experiments.", result.description());
        assertTrue(result.legendary());
        assertEquals("rare", result.habitat());
    }

    @Test
    @Disabled
    // This could be enabled if we want to test the connection to the remote api.
    public void testGetPokemonByNameWithRemoteRequest() {
        var repo = new PokeapiRepository(new RestTemplate());
        var result = repo.getPokemonByName("mewtwo");

        assertEquals("mewtwo", result.name());
        assertEquals("It was created by a scientist after years of horrific gene splicing and DNA engineering experiments.", result.description());
        assertTrue(result.legendary());
        assertEquals("rare", result.habitat());
    }


    private String mewtwoJson = "{\n" +
            "   \"base_happiness\":0,\n" +
            "   \"capture_rate\":3,\n" +
            "   \"color\":{\n" +
            "      \"name\":\"purple\",\n" +
            "      \"url\":\"https://pokeapi.co/api/v2/pokemon-color/7/\"\n" +
            "   },\n" +
            "   \"egg_groups\":[\n" +
            "      {\n" +
            "         \"name\":\"no-eggs\",\n" +
            "         \"url\":\"https://pokeapi.co/api/v2/egg-group/15/\"\n" +
            "      }\n" +
            "   ],\n" +
            "   \"evolution_chain\":{\n" +
            "      \"url\":\"https://pokeapi.co/api/v2/evolution-chain/77/\"\n" +
            "   },\n" +
            "   \"evolves_from_species\":null,\n" +
            "   \"flavor_text_entries\":[\n" +
            "      {\n" +
            "         \"flavor_text\":\"It was created by\\na scientist after\\nyears of horrific\\fgene splicing and\\nDNA engineering\\nexperiments.\",\n" +
            "         \"language\":{\n" +
            "            \"name\":\"en\",\n" +
            "            \"url\":\"https://pokeapi.co/api/v2/language/9/\"\n" +
            "         },\n" +
            "         \"version\":{\n" +
            "            \"name\":\"red\",\n" +
            "            \"url\":\"https://pokeapi.co/api/v2/version/1/\"\n" +
            "         }\n" +
            "      },\n" +
            "      {\n" +
            "         \"flavor_text\":\"It was created by\\na scientist after\\nyears of horrific\\fgene splicing and\\nDNA engineering\\nexperiments.\",\n" +
            "         \"language\":{\n" +
            "            \"name\":\"en\",\n" +
            "            \"url\":\"https://pokeapi.co/api/v2/language/9/\"\n" +
            "         },\n" +
            "         \"version\":{\n" +
            "            \"name\":\"blue\",\n" +
            "            \"url\":\"https://pokeapi.co/api/v2/version/2/\"\n" +
            "         }\n" +
            "      },\n" +
            "      {\n" +
            "         \"flavor_text\":\"Its DNA is almost\\nthe same as MEW's.\\nHowever, its size\\fand disposition\\nare vastly dif\u00AD\\nferent.\",\n" +
            "         \"language\":{\n" +
            "            \"name\":\"en\",\n" +
            "            \"url\":\"https://pokeapi.co/api/v2/language/9/\"\n" +
            "         },\n" +
            "         \"version\":{\n" +
            "            \"name\":\"yellow\",\n" +
            "            \"url\":\"https://pokeapi.co/api/v2/version/3/\"\n" +
            "         }\n" +
            "      },\n" +
            "      {\n" +
            "         \"flavor_text\":\"Because its battle\\nabilities were\\nraised to the\\fultimate level, it\\nthinks only of de\u00AD\\nfeating its foes.\",\n" +
            "         \"language\":{\n" +
            "            \"name\":\"en\",\n" +
            "            \"url\":\"https://pokeapi.co/api/v2/language/9/\"\n" +
            "         },\n" +
            "         \"version\":{\n" +
            "            \"name\":\"gold\",\n" +
            "            \"url\":\"https://pokeapi.co/api/v2/version/4/\"\n" +
            "         }\n" +
            "      },\n" +
            "      {\n" +
            "         \"flavor_text\":\"It usually remains\\nmotionless to con\u00AD\\nserve energy, so\\fthat it may un\u00AD\\nleash its full\\npower in battle.\",\n" +
            "         \"language\":{\n" +
            "            \"name\":\"en\",\n" +
            "            \"url\":\"https://pokeapi.co/api/v2/language/9/\"\n" +
            "         },\n" +
            "         \"version\":{\n" +
            "            \"name\":\"silver\",\n" +
            "            \"url\":\"https://pokeapi.co/api/v2/version/5/\"\n" +
            "         }\n" +
            "      },\n" +
            "      {\n" +
            "         \"flavor_text\":\"Said to rest qui\u00AD\\netly in an\\nundiscovered cave,\\fthis POKéMON was\\ncreated solely for\\nbattling.\",\n" +
            "         \"language\":{\n" +
            "            \"name\":\"en\",\n" +
            "            \"url\":\"https://pokeapi.co/api/v2/language/9/\"\n" +
            "         },\n" +
            "         \"version\":{\n" +
            "            \"name\":\"crystal\",\n" +
            "            \"url\":\"https://pokeapi.co/api/v2/version/6/\"\n" +
            "         }\n" +
            "      },\n" +
            "      {\n" +
            "         \"flavor_text\":\"MEWTWO is a POKéMON that was created\\nby genetic manipulation.\\nHowever, even though the scientific\\fpower of humans created this POKéMON’s\\nbody, they failed to endow MEWTWO with\\na compassionate heart.\",\n" +
            "         \"language\":{\n" +
            "            \"name\":\"en\",\n" +
            "            \"url\":\"https://pokeapi.co/api/v2/language/9/\"\n" +
            "         },\n" +
            "         \"version\":{\n" +
            "            \"name\":\"ruby\",\n" +
            "            \"url\":\"https://pokeapi.co/api/v2/version/7/\"\n" +
            "         }\n" +
            "      },\n" +
            "      {\n" +
            "         \"flavor_text\":\"MEWTWO is a POKéMON that was created\\nby genetic manipulation.\\nHowever, even though the scientific\\fpower of humans created this POKéMON’s\\nbody, they failed to endow MEWTWO with\\na compassionate heart.\",\n" +
            "         \"language\":{\n" +
            "            \"name\":\"en\",\n" +
            "            \"url\":\"https://pokeapi.co/api/v2/language/9/\"\n" +
            "         },\n" +
            "         \"version\":{\n" +
            "            \"name\":\"sapphire\",\n" +
            "            \"url\":\"https://pokeapi.co/api/v2/version/8/\"\n" +
            "         }\n" +
            "      },\n" +
            "      {\n" +
            "         \"flavor_text\":\"A POKéMON that was created by genetic\\nmanipulation. However, even though the\\nscientific power of humans made its body,\\nthey failed to give it a warm heart.\",\n" +
            "         \"language\":{\n" +
            "            \"name\":\"en\",\n" +
            "            \"url\":\"https://pokeapi.co/api/v2/language/9/\"\n" +
            "         },\n" +
            "         \"version\":{\n" +
            "            \"name\":\"emerald\",\n" +
            "            \"url\":\"https://pokeapi.co/api/v2/version/9/\"\n" +
            "         }\n" +
            "      },\n" +
            "      {\n" +
            "         \"flavor_text\":\"A POKéMON whose genetic code was\\nrepeatedly recombined for research.\\nIt turned vicious as a result.\",\n" +
            "         \"language\":{\n" +
            "            \"name\":\"en\",\n" +
            "            \"url\":\"https://pokeapi.co/api/v2/language/9/\"\n" +
            "         },\n" +
            "         \"version\":{\n" +
            "            \"name\":\"firered\",\n" +
            "            \"url\":\"https://pokeapi.co/api/v2/version/10/\"\n" +
            "         }\n" +
            "      },\n" +
            "      {\n" +
            "         \"flavor_text\":\"It was created by a scientist after years\\nof horrific gene-splicing and DNA-\\nengineering experiments.\",\n" +
            "         \"language\":{\n" +
            "            \"name\":\"en\",\n" +
            "            \"url\":\"https://pokeapi.co/api/v2/language/9/\"\n" +
            "         },\n" +
            "         \"version\":{\n" +
            "            \"name\":\"leafgreen\",\n" +
            "            \"url\":\"https://pokeapi.co/api/v2/version/11/\"\n" +
            "         }\n" +
            "      },\n" +
            "      {\n" +
            "         \"flavor_text\":\"A Pokémon created by recombining\\nMEW’s genes. It’s said to have the\\nmost savage heart among Pokémon.\",\n" +
            "         \"language\":{\n" +
            "            \"name\":\"en\",\n" +
            "            \"url\":\"https://pokeapi.co/api/v2/language/9/\"\n" +
            "         },\n" +
            "         \"version\":{\n" +
            "            \"name\":\"diamond\",\n" +
            "            \"url\":\"https://pokeapi.co/api/v2/version/12/\"\n" +
            "         }\n" +
            "      },\n" +
            "      {\n" +
            "         \"flavor_text\":\"A Pokémon created by recombining\\nMEW’s genes. It’s said to have the\\nmost savage heart among Pokémon.\",\n" +
            "         \"language\":{\n" +
            "            \"name\":\"en\",\n" +
            "            \"url\":\"https://pokeapi.co/api/v2/language/9/\"\n" +
            "         },\n" +
            "         \"version\":{\n" +
            "            \"name\":\"pearl\",\n" +
            "            \"url\":\"https://pokeapi.co/api/v2/version/13/\"\n" +
            "         }\n" +
            "      },\n" +
            "      {\n" +
            "         \"flavor_text\":\"A Pokémon created by recombining\\nMEW’s genes. It’s said to have the\\nmost savage heart among Pokémon.\",\n" +
            "         \"language\":{\n" +
            "            \"name\":\"en\",\n" +
            "            \"url\":\"https://pokeapi.co/api/v2/language/9/\"\n" +
            "         },\n" +
            "         \"version\":{\n" +
            "            \"name\":\"platinum\",\n" +
            "            \"url\":\"https://pokeapi.co/api/v2/version/14/\"\n" +
            "         }\n" +
            "      },\n" +
            "      {\n" +
            "         \"flavor_text\":\"Because its battle abilities were\\nraised to the ultimate level,\\nit thinks only of defeating its foes.\",\n" +
            "         \"language\":{\n" +
            "            \"name\":\"en\",\n" +
            "            \"url\":\"https://pokeapi.co/api/v2/language/9/\"\n" +
            "         },\n" +
            "         \"version\":{\n" +
            "            \"name\":\"heartgold\",\n" +
            "            \"url\":\"https://pokeapi.co/api/v2/version/15/\"\n" +
            "         }\n" +
            "      },\n" +
            "      {\n" +
            "         \"flavor_text\":\"It usually remains motionless to\\nconserve energy, so that it may\\nunleash its full power in battle.\",\n" +
            "         \"language\":{\n" +
            "            \"name\":\"en\",\n" +
            "            \"url\":\"https://pokeapi.co/api/v2/language/9/\"\n" +
            "         },\n" +
            "         \"version\":{\n" +
            "            \"name\":\"soulsilver\",\n" +
            "            \"url\":\"https://pokeapi.co/api/v2/version/16/\"\n" +
            "         }\n" +
            "      },\n" +
            "      {\n" +
            "         \"flavor_text\":\"Un Pokémon conçu en réorganisant\\nles gènes de Mew. On raconte qu’il\\ns’agit du Pokémon le plus féroce.\",\n" +
            "         \"language\":{\n" +
            "            \"name\":\"fr\",\n" +
            "            \"url\":\"https://pokeapi.co/api/v2/language/5/\"\n" +
            "         },\n" +
            "         \"version\":{\n" +
            "            \"name\":\"black\",\n" +
            "            \"url\":\"https://pokeapi.co/api/v2/version/17/\"\n" +
            "         }\n" +
            "      },\n" +
            "      {\n" +
            "         \"flavor_text\":\"A Pokémon created by recombining\\nMew’s genes. It’s said to have the\\nmost savage heart among Pokémon.\",\n" +
            "         \"language\":{\n" +
            "            \"name\":\"en\",\n" +
            "            \"url\":\"https://pokeapi.co/api/v2/language/9/\"\n" +
            "         },\n" +
            "         \"version\":{\n" +
            "            \"name\":\"black\",\n" +
            "            \"url\":\"https://pokeapi.co/api/v2/version/17/\"\n" +
            "         }\n" +
            "      },\n" +
            "      {\n" +
            "         \"flavor_text\":\"Un Pokémon conçu en réorganisant\\nles gènes de Mew. On raconte qu’il\\ns’agit du Pokémon le plus féroce.\",\n" +
            "         \"language\":{\n" +
            "            \"name\":\"fr\",\n" +
            "            \"url\":\"https://pokeapi.co/api/v2/language/5/\"\n" +
            "         },\n" +
            "         \"version\":{\n" +
            "            \"name\":\"white\",\n" +
            "            \"url\":\"https://pokeapi.co/api/v2/version/18/\"\n" +
            "         }\n" +
            "      },\n" +
            "      {\n" +
            "         \"flavor_text\":\"A Pokémon created by recombining\\nMew’s genes. It’s said to have the\\nmost savage heart among Pokémon.\",\n" +
            "         \"language\":{\n" +
            "            \"name\":\"en\",\n" +
            "            \"url\":\"https://pokeapi.co/api/v2/language/9/\"\n" +
            "         },\n" +
            "         \"version\":{\n" +
            "            \"name\":\"white\",\n" +
            "            \"url\":\"https://pokeapi.co/api/v2/version/18/\"\n" +
            "         }\n" +
            "      },\n" +
            "      {\n" +
            "         \"flavor_text\":\"A Pokémon created by recombining\\nMew’s genes. It’s said to have the\\nmost savage heart among Pokémon.\",\n" +
            "         \"language\":{\n" +
            "            \"name\":\"en\",\n" +
            "            \"url\":\"https://pokeapi.co/api/v2/language/9/\"\n" +
            "         },\n" +
            "         \"version\":{\n" +
            "            \"name\":\"black-2\",\n" +
            "            \"url\":\"https://pokeapi.co/api/v2/version/21/\"\n" +
            "         }\n" +
            "      },\n" +
            "      {\n" +
            "         \"flavor_text\":\"A Pokémon created by recombining\\nMew’s genes. It’s said to have the\\nmost savage heart among Pokémon.\",\n" +
            "         \"language\":{\n" +
            "            \"name\":\"en\",\n" +
            "            \"url\":\"https://pokeapi.co/api/v2/language/9/\"\n" +
            "         },\n" +
            "         \"version\":{\n" +
            "            \"name\":\"white-2\",\n" +
            "            \"url\":\"https://pokeapi.co/api/v2/version/22/\"\n" +
            "         }\n" +
            "      },\n" +
            "      {\n" +
            "         \"flavor_text\":\"ひとりの　かがくしゃが　なんねんも\\nおそろしい　いでんし　けんきゅうを\\nつづけた　けっか　たんじょうした。\",\n" +
            "         \"language\":{\n" +
            "            \"name\":\"ja-Hrkt\",\n" +
            "            \"url\":\"https://pokeapi.co/api/v2/language/1/\"\n" +
            "         },\n" +
            "         \"version\":{\n" +
            "            \"name\":\"x\",\n" +
            "            \"url\":\"https://pokeapi.co/api/v2/version/23/\"\n" +
            "         }\n" +
            "      },\n" +
            "      {\n" +
            "         \"flavor_text\":\"한 과학자가 몇 년에 걸쳐\\n무서운 유전자의 연구를\\n계속한 결과 탄생했다.\",\n" +
            "         \"language\":{\n" +
            "            \"name\":\"ko\",\n" +
            "            \"url\":\"https://pokeapi.co/api/v2/language/3/\"\n" +
            "         },\n" +
            "         \"version\":{\n" +
            "            \"name\":\"x\",\n" +
            "            \"url\":\"https://pokeapi.co/api/v2/version/23/\"\n" +
            "         }\n" +
            "      },\n" +
            "      {\n" +
            "         \"flavor_text\":\"Il est le fruit de nombreuses expériences génétiques\\nhorribles et malsaines.\",\n" +
            "         \"language\":{\n" +
            "            \"name\":\"fr\",\n" +
            "            \"url\":\"https://pokeapi.co/api/v2/language/5/\"\n" +
            "         },\n" +
            "         \"version\":{\n" +
            "            \"name\":\"x\",\n" +
            "            \"url\":\"https://pokeapi.co/api/v2/version/23/\"\n" +
            "         }\n" +
            "      },\n" +
            "      {\n" +
            "         \"flavor_text\":\"Dieses Pokémon ist das Resultat eines jahrelangen\\nund skrupellosen Experimentes.\",\n" +
            "         \"language\":{\n" +
            "            \"name\":\"de\",\n" +
            "            \"url\":\"https://pokeapi.co/api/v2/language/6/\"\n" +
            "         },\n" +
            "         \"version\":{\n" +
            "            \"name\":\"x\",\n" +
            "            \"url\":\"https://pokeapi.co/api/v2/version/23/\"\n" +
            "         }\n" +
            "      },\n" +
            "      {\n" +
            "         \"flavor_text\":\"Fue creado por un científico tras años de horribles\\nexperimentos de ingeniería genética.\",\n" +
            "         \"language\":{\n" +
            "            \"name\":\"es\",\n" +
            "            \"url\":\"https://pokeapi.co/api/v2/language/7/\"\n" +
            "         },\n" +
            "         \"version\":{\n" +
            "            \"name\":\"x\",\n" +
            "            \"url\":\"https://pokeapi.co/api/v2/version/23/\"\n" +
            "         }\n" +
            "      },\n" +
            "      {\n" +
            "         \"flavor_text\":\"Creato da uno scienziato dopo anni di orribili\\nesperimenti di ingegneria genetica.\",\n" +
            "         \"language\":{\n" +
            "            \"name\":\"it\",\n" +
            "            \"url\":\"https://pokeapi.co/api/v2/language/8/\"\n" +
            "         },\n" +
            "         \"version\":{\n" +
            "            \"name\":\"x\",\n" +
            "            \"url\":\"https://pokeapi.co/api/v2/version/23/\"\n" +
            "         }\n" +
            "      },\n" +
            "      {\n" +
            "         \"flavor_text\":\"It was created by a scientist after years of horrific\\ngene-splicing and DNA-engineering experiments.\",\n" +
            "         \"language\":{\n" +
            "            \"name\":\"en\",\n" +
            "            \"url\":\"https://pokeapi.co/api/v2/language/9/\"\n" +
            "         },\n" +
            "         \"version\":{\n" +
            "            \"name\":\"x\",\n" +
            "            \"url\":\"https://pokeapi.co/api/v2/version/23/\"\n" +
            "         }\n" +
            "      },\n" +
            "      {\n" +
            "         \"flavor_text\":\"１人の　科学者が　何年も\\n恐ろしい　遺伝子　研究を\\n続けた　結果　誕生した。\",\n" +
            "         \"language\":{\n" +
            "            \"name\":\"ja\",\n" +
            "            \"url\":\"https://pokeapi.co/api/v2/language/11/\"\n" +
            "         },\n" +
            "         \"version\":{\n" +
            "            \"name\":\"x\",\n" +
            "            \"url\":\"https://pokeapi.co/api/v2/version/23/\"\n" +
            "         }\n" +
            "      },\n" +
            "      {\n" +
            "         \"flavor_text\":\"ミュウの　いでんしを　くみかえて\\nうみだされた。ポケモンで　いちばん\\nきょうぼうな　こころを　もつという。\",\n" +
            "         \"language\":{\n" +
            "            \"name\":\"ja-Hrkt\",\n" +
            "            \"url\":\"https://pokeapi.co/api/v2/language/1/\"\n" +
            "         },\n" +
            "         \"version\":{\n" +
            "            \"name\":\"y\",\n" +
            "            \"url\":\"https://pokeapi.co/api/v2/version/24/\"\n" +
            "         }\n" +
            "      },\n" +
            "      {\n" +
            "         \"flavor_text\":\"뮤의 유전자를 재구성해서\\n만들어졌다. 포켓몬 중에서 가장\\n난폭한 마음을 가지고 있다고 한다.\",\n" +
            "         \"language\":{\n" +
            "            \"name\":\"ko\",\n" +
            "            \"url\":\"https://pokeapi.co/api/v2/language/3/\"\n" +
            "         },\n" +
            "         \"version\":{\n" +
            "            \"name\":\"y\",\n" +
            "            \"url\":\"https://pokeapi.co/api/v2/version/24/\"\n" +
            "         }\n" +
            "      },\n" +
            "      {\n" +
            "         \"flavor_text\":\"Un Pokémon conçu en réorganisant les gènes de\\nMew. On raconte qu’il s’agit du Pokémon le plus\\nféroce.\",\n" +
            "         \"language\":{\n" +
            "            \"name\":\"fr\",\n" +
            "            \"url\":\"https://pokeapi.co/api/v2/language/5/\"\n" +
            "         },\n" +
            "         \"version\":{\n" +
            "            \"name\":\"y\",\n" +
            "            \"url\":\"https://pokeapi.co/api/v2/version/24/\"\n" +
            "         }\n" +
            "      },\n" +
            "      {\n" +
            "         \"flavor_text\":\"Die Gene von Mew wurden neu angeordnet, wodurch\\ndieses Pokémon entstand. Es hat ein wildes Herz.\",\n" +
            "         \"language\":{\n" +
            "            \"name\":\"de\",\n" +
            "            \"url\":\"https://pokeapi.co/api/v2/language/6/\"\n" +
            "         },\n" +
            "         \"version\":{\n" +
            "            \"name\":\"y\",\n" +
            "            \"url\":\"https://pokeapi.co/api/v2/version/24/\"\n" +
            "         }\n" +
            "      },\n" +
            "      {\n" +
            "         \"flavor_text\":\"Pokémon creado por recombinación genética de Mew.\\nSe dice que es el más salvaje de los Pokémon.\",\n" +
            "         \"language\":{\n" +
            "            \"name\":\"es\",\n" +
            "            \"url\":\"https://pokeapi.co/api/v2/language/7/\"\n" +
            "         },\n" +
            "         \"version\":{\n" +
            "            \"name\":\"y\",\n" +
            "            \"url\":\"https://pokeapi.co/api/v2/version/24/\"\n" +
            "         }\n" +
            "      },\n" +
            "      {\n" +
            "         \"flavor_text\":\"Un Pokémon creato usando i geni di Mew. Si dice che\\nfra i Pokémon sia quello con l’animo più crudele.\",\n" +
            "         \"language\":{\n" +
            "            \"name\":\"it\",\n" +
            "            \"url\":\"https://pokeapi.co/api/v2/language/8/\"\n" +
            "         },\n" +
            "         \"version\":{\n" +
            "            \"name\":\"y\",\n" +
            "            \"url\":\"https://pokeapi.co/api/v2/version/24/\"\n" +
            "         }\n" +
            "      },\n" +
            "      {\n" +
            "         \"flavor_text\":\"A Pokémon created by recombining Mew’s genes.\\nIt’s said to have the most savage heart\\namong Pokémon.\",\n" +
            "         \"language\":{\n" +
            "            \"name\":\"en\",\n" +
            "            \"url\":\"https://pokeapi.co/api/v2/language/9/\"\n" +
            "         },\n" +
            "         \"version\":{\n" +
            "            \"name\":\"y\",\n" +
            "            \"url\":\"https://pokeapi.co/api/v2/version/24/\"\n" +
            "         }\n" +
            "      },\n" +
            "      {\n" +
            "         \"flavor_text\":\"ミュウの　遺伝子を　組み替えて\\n生み出された。ポケモンで　一番\\n凶暴な　心を　持つという。\",\n" +
            "         \"language\":{\n" +
            "            \"name\":\"ja\",\n" +
            "            \"url\":\"https://pokeapi.co/api/v2/language/11/\"\n" +
            "         },\n" +
            "         \"version\":{\n" +
            "            \"name\":\"y\",\n" +
            "            \"url\":\"https://pokeapi.co/api/v2/version/24/\"\n" +
            "         }\n" +
            "      },\n" +
            "      {\n" +
            "         \"flavor_text\":\"いでんしそうさに　よって　つくられた　ポケモン。\\nにんげんの　かがくりょくで　からだは　つくれても\\nやさしい　こころを　つくることは　できなかった。\",\n" +
            "         \"language\":{\n" +
            "            \"name\":\"ja-Hrkt\",\n" +
            "            \"url\":\"https://pokeapi.co/api/v2/language/1/\"\n" +
            "         },\n" +
            "         \"version\":{\n" +
            "            \"name\":\"omega-ruby\",\n" +
            "            \"url\":\"https://pokeapi.co/api/v2/version/25/\"\n" +
            "         }\n" +
            "      },\n" +
            "      {\n" +
            "         \"flavor_text\":\"유전자조작을 통해 만들어진 포켓몬이다.\\n인간은 과학의 힘으로 몸은 만들었지만\\n상냥한 마음을 만들 수는 없었다.\",\n" +
            "         \"language\":{\n" +
            "            \"name\":\"ko\",\n" +
            "            \"url\":\"https://pokeapi.co/api/v2/language/3/\"\n" +
            "         },\n" +
            "         \"version\":{\n" +
            "            \"name\":\"omega-ruby\",\n" +
            "            \"url\":\"https://pokeapi.co/api/v2/version/25/\"\n" +
            "         }\n" +
            "      },\n" +
            "      {\n" +
            "         \"flavor_text\":\"Mewtwo est un Pokémon créé par manipulation génétique.\\nCependant, bien que les connaissances scientifiques des\\nhumains aient réussi à créer son corps, elles n’ont pas pu\\ndoter Mewtwo d’un cœur sensible.\",\n" +
            "         \"language\":{\n" +
            "            \"name\":\"fr\",\n" +
            "            \"url\":\"https://pokeapi.co/api/v2/language/5/\"\n" +
            "         },\n" +
            "         \"version\":{\n" +
            "            \"name\":\"omega-ruby\",\n" +
            "            \"url\":\"https://pokeapi.co/api/v2/version/25/\"\n" +
            "         }\n" +
            "      },\n" +
            "      {\n" +
            "         \"flavor_text\":\"Mewtu ist ein Pokémon, das durch Genmanipulation\\nentstanden ist. Die Menschen haben es zwar mit ihrem\\nwissenschaftlichen Sachverstand erzeugt, aber nicht mit\\neinem mitfühlenden Herzen ausgestattet.\",\n" +
            "         \"language\":{\n" +
            "            \"name\":\"de\",\n" +
            "            \"url\":\"https://pokeapi.co/api/v2/language/6/\"\n" +
            "         },\n" +
            "         \"version\":{\n" +
            "            \"name\":\"omega-ruby\",\n" +
            "            \"url\":\"https://pokeapi.co/api/v2/version/25/\"\n" +
            "         }\n" +
            "      },\n" +
            "      {\n" +
            "         \"flavor_text\":\"Mewtwo fue creado por manipulación genética. Pero, a pesar\\nde que el hombre creó su cuerpo, dotar a Mewtwo de un\\ncorazón compasivo quedó en el olvido.\",\n" +
            "         \"language\":{\n" +
            "            \"name\":\"es\",\n" +
            "            \"url\":\"https://pokeapi.co/api/v2/language/7/\"\n" +
            "         },\n" +
            "         \"version\":{\n" +
            "            \"name\":\"omega-ruby\",\n" +
            "            \"url\":\"https://pokeapi.co/api/v2/version/25/\"\n" +
            "         }\n" +
            "      },\n" +
            "      {\n" +
            "         \"flavor_text\":\"Mewtwo è stato creato grazie a una manipolazione genetica.\\nTuttavia, sebbene la scienza sia riuscita a creare un corpo\\ndi Pokémon, ha fallito nell’intento di dare a Mewtwo\\nun animo generoso.\",\n" +
            "         \"language\":{\n" +
            "            \"name\":\"it\",\n" +
            "            \"url\":\"https://pokeapi.co/api/v2/language/8/\"\n" +
            "         },\n" +
            "         \"version\":{\n" +
            "            \"name\":\"omega-ruby\",\n" +
            "            \"url\":\"https://pokeapi.co/api/v2/version/25/\"\n" +
            "         }\n" +
            "      },\n" +
            "      {\n" +
            "         \"flavor_text\":\"Mewtwo is a Pokémon that was created by genetic\\nmanipulation. However, even though the scientific power of\\nhumans created this Pokémon’s body, they failed to endow\\nMewtwo with a compassionate heart.\",\n" +
            "         \"language\":{\n" +
            "            \"name\":\"en\",\n" +
            "            \"url\":\"https://pokeapi.co/api/v2/language/9/\"\n" +
            "         },\n" +
            "         \"version\":{\n" +
            "            \"name\":\"omega-ruby\",\n" +
            "            \"url\":\"https://pokeapi.co/api/v2/version/25/\"\n" +
            "         }\n" +
            "      },\n" +
            "      {\n" +
            "         \"flavor_text\":\"遺伝子操作に　よって　つくられた　ポケモン。\\n人間の　科学力で　体は　つくれても\\n優しい　心を　つくることは　できなかった。\",\n" +
            "         \"language\":{\n" +
            "            \"name\":\"ja\",\n" +
            "            \"url\":\"https://pokeapi.co/api/v2/language/11/\"\n" +
            "         },\n" +
            "         \"version\":{\n" +
            "            \"name\":\"omega-ruby\",\n" +
            "            \"url\":\"https://pokeapi.co/api/v2/version/25/\"\n" +
            "         }\n" +
            "      },\n" +
            "      {\n" +
            "         \"flavor_text\":\"いでんしそうさに　よって　つくられた　ポケモン。\\nにんげんの　かがくりょくで　からだは　つくれても\\nやさしい　こころを　つくることは　できなかった。\",\n" +
            "         \"language\":{\n" +
            "            \"name\":\"ja-Hrkt\",\n" +
            "            \"url\":\"https://pokeapi.co/api/v2/language/1/\"\n" +
            "         },\n" +
            "         \"version\":{\n" +
            "            \"name\":\"alpha-sapphire\",\n" +
            "            \"url\":\"https://pokeapi.co/api/v2/version/26/\"\n" +
            "         }\n" +
            "      },\n" +
            "      {\n" +
            "         \"flavor_text\":\"유전자조작을 통해 만들어진 포켓몬이다.\\n인간은 과학의 힘으로 몸은 만들었지만\\n상냥한 마음을 만들 수는 없었다.\",\n" +
            "         \"language\":{\n" +
            "            \"name\":\"ko\",\n" +
            "            \"url\":\"https://pokeapi.co/api/v2/language/3/\"\n" +
            "         },\n" +
            "         \"version\":{\n" +
            "            \"name\":\"alpha-sapphire\",\n" +
            "            \"url\":\"https://pokeapi.co/api/v2/version/26/\"\n" +
            "         }\n" +
            "      },\n" +
            "      {\n" +
            "         \"flavor_text\":\"Mewtwo est un Pokémon créé par manipulation génétique.\\nCependant, bien que les connaissances scientifiques des\\nhumains aient réussi à créer son corps, elles n’ont pas pu\\ndoter Mewtwo d’un cœur sensible.\",\n" +
            "         \"language\":{\n" +
            "            \"name\":\"fr\",\n" +
            "            \"url\":\"https://pokeapi.co/api/v2/language/5/\"\n" +
            "         },\n" +
            "         \"version\":{\n" +
            "            \"name\":\"alpha-sapphire\",\n" +
            "            \"url\":\"https://pokeapi.co/api/v2/version/26/\"\n" +
            "         }\n" +
            "      },\n" +
            "      {\n" +
            "         \"flavor_text\":\"Mewtu ist ein Pokémon, das durch Genmanipulation\\nentstanden ist. Die Menschen haben es zwar mit ihrem\\nwissenschaftlichen Sachverstand erzeugt, aber nicht mit\\neinem mitfühlenden Herzen ausgestattet.\",\n" +
            "         \"language\":{\n" +
            "            \"name\":\"de\",\n" +
            "            \"url\":\"https://pokeapi.co/api/v2/language/6/\"\n" +
            "         },\n" +
            "         \"version\":{\n" +
            "            \"name\":\"alpha-sapphire\",\n" +
            "            \"url\":\"https://pokeapi.co/api/v2/version/26/\"\n" +
            "         }\n" +
            "      },\n" +
            "      {\n" +
            "         \"flavor_text\":\"Mewtwo fue creado por manipulación genética. Pero, a pesar\\nde que el hombre creó su cuerpo, dotar a Mewtwo de un\\ncorazón compasivo quedó en el olvido.\",\n" +
            "         \"language\":{\n" +
            "            \"name\":\"es\",\n" +
            "            \"url\":\"https://pokeapi.co/api/v2/language/7/\"\n" +
            "         },\n" +
            "         \"version\":{\n" +
            "            \"name\":\"alpha-sapphire\",\n" +
            "            \"url\":\"https://pokeapi.co/api/v2/version/26/\"\n" +
            "         }\n" +
            "      },\n" +
            "      {\n" +
            "         \"flavor_text\":\"Mewtwo è stato creato grazie a una manipolazione genetica.\\nTuttavia, sebbene la scienza sia riuscita a creare un corpo\\ndi Pokémon, ha fallito nell’intento di dare a Mewtwo\\nun animo generoso.\",\n" +
            "         \"language\":{\n" +
            "            \"name\":\"it\",\n" +
            "            \"url\":\"https://pokeapi.co/api/v2/language/8/\"\n" +
            "         },\n" +
            "         \"version\":{\n" +
            "            \"name\":\"alpha-sapphire\",\n" +
            "            \"url\":\"https://pokeapi.co/api/v2/version/26/\"\n" +
            "         }\n" +
            "      },\n" +
            "      {\n" +
            "         \"flavor_text\":\"Mewtwo is a Pokémon that was created by genetic\\nmanipulation. However, even though the scientific power\\nof humans created this Pokémon’s body, they failed to\\nendow Mewtwo with a compassionate heart.\",\n" +
            "         \"language\":{\n" +
            "            \"name\":\"en\",\n" +
            "            \"url\":\"https://pokeapi.co/api/v2/language/9/\"\n" +
            "         },\n" +
            "         \"version\":{\n" +
            "            \"name\":\"alpha-sapphire\",\n" +
            "            \"url\":\"https://pokeapi.co/api/v2/version/26/\"\n" +
            "         }\n" +
            "      },\n" +
            "      {\n" +
            "         \"flavor_text\":\"遺伝子操作に　よって　つくられた　ポケモン。\\n人間の　科学力で　体は　つくれても\\n優しい　心を　つくることは　できなかった。\",\n" +
            "         \"language\":{\n" +
            "            \"name\":\"ja\",\n" +
            "            \"url\":\"https://pokeapi.co/api/v2/language/11/\"\n" +
            "         },\n" +
            "         \"version\":{\n" +
            "            \"name\":\"alpha-sapphire\",\n" +
            "            \"url\":\"https://pokeapi.co/api/v2/version/26/\"\n" +
            "         }\n" +
            "      },\n" +
            "      {\n" +
            "         \"flavor_text\":\"ミュウの　いでんしと　ほとんど\\nおなじ。だが　おおきさも　せいかくも\\nおそろしいほど　ちがっている。\",\n" +
            "         \"language\":{\n" +
            "            \"name\":\"ja-Hrkt\",\n" +
            "            \"url\":\"https://pokeapi.co/api/v2/language/1/\"\n" +
            "         },\n" +
            "         \"version\":{\n" +
            "            \"name\":\"lets-go-pikachu\",\n" +
            "            \"url\":\"https://pokeapi.co/api/v2/version/31/\"\n" +
            "         }\n" +
            "      },\n" +
            "      {\n" +
            "         \"flavor_text\":\"뮤의 유전자와 거의 같다.\\n하지만 크기도 성격도\\n무서울 정도로 다르다.\",\n" +
            "         \"language\":{\n" +
            "            \"name\":\"ko\",\n" +
            "            \"url\":\"https://pokeapi.co/api/v2/language/3/\"\n" +
            "         },\n" +
            "         \"version\":{\n" +
            "            \"name\":\"lets-go-pikachu\",\n" +
            "            \"url\":\"https://pokeapi.co/api/v2/version/31/\"\n" +
            "         }\n" +
            "      },\n" +
            "      {\n" +
            "         \"flavor_text\":\"身上的基因與夢幻幾乎一樣，\\n但無論是體型大小還是性格\\n都與夢幻有著巨大的差別。\",\n" +
            "         \"language\":{\n" +
            "            \"name\":\"zh-Hant\",\n" +
            "            \"url\":\"https://pokeapi.co/api/v2/language/4/\"\n" +
            "         },\n" +
            "         \"version\":{\n" +
            "            \"name\":\"lets-go-pikachu\",\n" +
            "            \"url\":\"https://pokeapi.co/api/v2/version/31/\"\n" +
            "         }\n" +
            "      },\n" +
            "      {\n" +
            "         \"flavor_text\":\"Son ADN est presque le même que celui de\\nMew, mais sa taille et son caractère sont très\\ndifférents.\",\n" +
            "         \"language\":{\n" +
            "            \"name\":\"fr\",\n" +
            "            \"url\":\"https://pokeapi.co/api/v2/language/5/\"\n" +
            "         },\n" +
            "         \"version\":{\n" +
            "            \"name\":\"lets-go-pikachu\",\n" +
            "            \"url\":\"https://pokeapi.co/api/v2/version/31/\"\n" +
            "         }\n" +
            "      },\n" +
            "      {\n" +
            "         \"flavor_text\":\"Mewtu und Mew weisen sehr ähnliche Gene auf,\\ndoch hinsichtlich ihres Charakters und ihrer\\nGröße unterscheiden sich die beiden erheblich.\",\n" +
            "         \"language\":{\n" +
            "            \"name\":\"de\",\n" +
            "            \"url\":\"https://pokeapi.co/api/v2/language/6/\"\n" +
            "         },\n" +
            "         \"version\":{\n" +
            "            \"name\":\"lets-go-pikachu\",\n" +
            "            \"url\":\"https://pokeapi.co/api/v2/version/31/\"\n" +
            "         }\n" +
            "      },\n" +
            "      {\n" +
            "         \"flavor_text\":\"Su ADN es casi el mismo que el de Mew.\\nSin embargo, su tamaño y carácter son muy\\ndiferentes.\",\n" +
            "         \"language\":{\n" +
            "            \"name\":\"es\",\n" +
            "            \"url\":\"https://pokeapi.co/api/v2/language/7/\"\n" +
            "         },\n" +
            "         \"version\":{\n" +
            "            \"name\":\"lets-go-pikachu\",\n" +
            "            \"url\":\"https://pokeapi.co/api/v2/version/31/\"\n" +
            "         }\n" +
            "      },\n" +
            "      {\n" +
            "         \"flavor_text\":\"Il suo DNA è quasi uguale a quello di Mew.\\nCiò nonostante, sono agli antipodi per\\ndimensioni e carattere.\",\n" +
            "         \"language\":{\n" +
            "            \"name\":\"it\",\n" +
            "            \"url\":\"https://pokeapi.co/api/v2/language/8/\"\n" +
            "         },\n" +
            "         \"version\":{\n" +
            "            \"name\":\"lets-go-pikachu\",\n" +
            "            \"url\":\"https://pokeapi.co/api/v2/version/31/\"\n" +
            "         }\n" +
            "      },\n" +
            "      {\n" +
            "         \"flavor_text\":\"Its DNA is almost the same as Mew’s. However,\\nits size and disposition are vastly different.\",\n" +
            "         \"language\":{\n" +
            "            \"name\":\"en\",\n" +
            "            \"url\":\"https://pokeapi.co/api/v2/language/9/\"\n" +
            "         },\n" +
            "         \"version\":{\n" +
            "            \"name\":\"lets-go-pikachu\",\n" +
            "            \"url\":\"https://pokeapi.co/api/v2/version/31/\"\n" +
            "         }\n" +
            "      },\n" +
            "      {\n" +
            "         \"flavor_text\":\"ミュウの　遺伝子と　ほとんど\\n同じ。だが　大きさも　性格も\\n恐ろしいほど　違っている。\",\n" +
            "         \"language\":{\n" +
            "            \"name\":\"ja\",\n" +
            "            \"url\":\"https://pokeapi.co/api/v2/language/11/\"\n" +
            "         },\n" +
            "         \"version\":{\n" +
            "            \"name\":\"lets-go-pikachu\",\n" +
            "            \"url\":\"https://pokeapi.co/api/v2/version/31/\"\n" +
            "         }\n" +
            "      },\n" +
            "      {\n" +
            "         \"flavor_text\":\"超梦的基因几乎和梦幻\\n完全一样，但是大小和\\n性格却迥异得让人吃惊。\",\n" +
            "         \"language\":{\n" +
            "            \"name\":\"zh-Hans\",\n" +
            "            \"url\":\"https://pokeapi.co/api/v2/language/12/\"\n" +
            "         },\n" +
            "         \"version\":{\n" +
            "            \"name\":\"lets-go-pikachu\",\n" +
            "            \"url\":\"https://pokeapi.co/api/v2/version/31/\"\n" +
            "         }\n" +
            "      },\n" +
            "      {\n" +
            "         \"flavor_text\":\"ミュウの　いでんしと　ほとんど\\nおなじ。だが　おおきさも　せいかくも\\nおそろしいほど　ちがっている。\",\n" +
            "         \"language\":{\n" +
            "            \"name\":\"ja-Hrkt\",\n" +
            "            \"url\":\"https://pokeapi.co/api/v2/language/1/\"\n" +
            "         },\n" +
            "         \"version\":{\n" +
            "            \"name\":\"lets-go-eevee\",\n" +
            "            \"url\":\"https://pokeapi.co/api/v2/version/32/\"\n" +
            "         }\n" +
            "      },\n" +
            "      {\n" +
            "         \"flavor_text\":\"뮤의 유전자와 거의 같다.\\n하지만 크기도 성격도\\n무서울 정도로 다르다.\",\n" +
            "         \"language\":{\n" +
            "            \"name\":\"ko\",\n" +
            "            \"url\":\"https://pokeapi.co/api/v2/language/3/\"\n" +
            "         },\n" +
            "         \"version\":{\n" +
            "            \"name\":\"lets-go-eevee\",\n" +
            "            \"url\":\"https://pokeapi.co/api/v2/version/32/\"\n" +
            "         }\n" +
            "      },\n" +
            "      {\n" +
            "         \"flavor_text\":\"身上的基因與夢幻幾乎一樣，\\n但無論是體型大小還是性格\\n都與夢幻有著巨大的差別。\",\n" +
            "         \"language\":{\n" +
            "            \"name\":\"zh-Hant\",\n" +
            "            \"url\":\"https://pokeapi.co/api/v2/language/4/\"\n" +
            "         },\n" +
            "         \"version\":{\n" +
            "            \"name\":\"lets-go-eevee\",\n" +
            "            \"url\":\"https://pokeapi.co/api/v2/version/32/\"\n" +
            "         }\n" +
            "      },\n" +
            "      {\n" +
            "         \"flavor_text\":\"Son ADN est presque le même que celui de\\nMew, mais sa taille et son caractère sont très\\ndifférents.\",\n" +
            "         \"language\":{\n" +
            "            \"name\":\"fr\",\n" +
            "            \"url\":\"https://pokeapi.co/api/v2/language/5/\"\n" +
            "         },\n" +
            "         \"version\":{\n" +
            "            \"name\":\"lets-go-eevee\",\n" +
            "            \"url\":\"https://pokeapi.co/api/v2/version/32/\"\n" +
            "         }\n" +
            "      },\n" +
            "      {\n" +
            "         \"flavor_text\":\"Mewtu und Mew weisen sehr ähnliche Gene auf,\\ndoch hinsichtlich ihres Charakters und ihrer\\nGröße unterscheiden sich die beiden erheblich.\",\n" +
            "         \"language\":{\n" +
            "            \"name\":\"de\",\n" +
            "            \"url\":\"https://pokeapi.co/api/v2/language/6/\"\n" +
            "         },\n" +
            "         \"version\":{\n" +
            "            \"name\":\"lets-go-eevee\",\n" +
            "            \"url\":\"https://pokeapi.co/api/v2/version/32/\"\n" +
            "         }\n" +
            "      },\n" +
            "      {\n" +
            "         \"flavor_text\":\"Su ADN es casi el mismo que el de Mew.\\nSin embargo, su tamaño y carácter son muy\\ndiferentes.\",\n" +
            "         \"language\":{\n" +
            "            \"name\":\"es\",\n" +
            "            \"url\":\"https://pokeapi.co/api/v2/language/7/\"\n" +
            "         },\n" +
            "         \"version\":{\n" +
            "            \"name\":\"lets-go-eevee\",\n" +
            "            \"url\":\"https://pokeapi.co/api/v2/version/32/\"\n" +
            "         }\n" +
            "      },\n" +
            "      {\n" +
            "         \"flavor_text\":\"Il suo DNA è quasi uguale a quello di Mew.\\nCiò nonostante, sono agli antipodi per\\ndimensioni e carattere.\",\n" +
            "         \"language\":{\n" +
            "            \"name\":\"it\",\n" +
            "            \"url\":\"https://pokeapi.co/api/v2/language/8/\"\n" +
            "         },\n" +
            "         \"version\":{\n" +
            "            \"name\":\"lets-go-eevee\",\n" +
            "            \"url\":\"https://pokeapi.co/api/v2/version/32/\"\n" +
            "         }\n" +
            "      },\n" +
            "      {\n" +
            "         \"flavor_text\":\"Its DNA is almost the same as Mew’s. However,\\nits size and disposition are vastly different.\",\n" +
            "         \"language\":{\n" +
            "            \"name\":\"en\",\n" +
            "            \"url\":\"https://pokeapi.co/api/v2/language/9/\"\n" +
            "         },\n" +
            "         \"version\":{\n" +
            "            \"name\":\"lets-go-eevee\",\n" +
            "            \"url\":\"https://pokeapi.co/api/v2/version/32/\"\n" +
            "         }\n" +
            "      },\n" +
            "      {\n" +
            "         \"flavor_text\":\"ミュウの　遺伝子と　ほとんど\\n同じ。だが　大きさも　性格も\\n恐ろしいほど　違っている。\",\n" +
            "         \"language\":{\n" +
            "            \"name\":\"ja\",\n" +
            "            \"url\":\"https://pokeapi.co/api/v2/language/11/\"\n" +
            "         },\n" +
            "         \"version\":{\n" +
            "            \"name\":\"lets-go-eevee\",\n" +
            "            \"url\":\"https://pokeapi.co/api/v2/version/32/\"\n" +
            "         }\n" +
            "      },\n" +
            "      {\n" +
            "         \"flavor_text\":\"超梦的基因几乎和梦幻\\n完全一样，但是大小和\\n性格却迥异得让人吃惊。\",\n" +
            "         \"language\":{\n" +
            "            \"name\":\"zh-Hans\",\n" +
            "            \"url\":\"https://pokeapi.co/api/v2/language/12/\"\n" +
            "         },\n" +
            "         \"version\":{\n" +
            "            \"name\":\"lets-go-eevee\",\n" +
            "            \"url\":\"https://pokeapi.co/api/v2/version/32/\"\n" +
            "         }\n" +
            "      }\n" +
            "   ],\n" +
            "   \"form_descriptions\":[\n" +
            "      \n" +
            "   ],\n" +
            "   \"forms_switchable\":true,\n" +
            "   \"gender_rate\":-1,\n" +
            "   \"genera\":[\n" +
            "      {\n" +
            "         \"genus\":\"いでんしポケモン\",\n" +
            "         \"language\":{\n" +
            "            \"name\":\"ja-Hrkt\",\n" +
            "            \"url\":\"https://pokeapi.co/api/v2/language/1/\"\n" +
            "         }\n" +
            "      },\n" +
            "      {\n" +
            "         \"genus\":\"유전포켓몬\",\n" +
            "         \"language\":{\n" +
            "            \"name\":\"ko\",\n" +
            "            \"url\":\"https://pokeapi.co/api/v2/language/3/\"\n" +
            "         }\n" +
            "      },\n" +
            "      {\n" +
            "         \"genus\":\"基因寶可夢\",\n" +
            "         \"language\":{\n" +
            "            \"name\":\"zh-Hant\",\n" +
            "            \"url\":\"https://pokeapi.co/api/v2/language/4/\"\n" +
            "         }\n" +
            "      },\n" +
            "      {\n" +
            "         \"genus\":\"Pokémon Génétique\",\n" +
            "         \"language\":{\n" +
            "            \"name\":\"fr\",\n" +
            "            \"url\":\"https://pokeapi.co/api/v2/language/5/\"\n" +
            "         }\n" +
            "      },\n" +
            "      {\n" +
            "         \"genus\":\"Genmutant\",\n" +
            "         \"language\":{\n" +
            "            \"name\":\"de\",\n" +
            "            \"url\":\"https://pokeapi.co/api/v2/language/6/\"\n" +
            "         }\n" +
            "      },\n" +
            "      {\n" +
            "         \"genus\":\"Pokémon Genético\",\n" +
            "         \"language\":{\n" +
            "            \"name\":\"es\",\n" +
            "            \"url\":\"https://pokeapi.co/api/v2/language/7/\"\n" +
            "         }\n" +
            "      },\n" +
            "      {\n" +
            "         \"genus\":\"Pokémon Genetico\",\n" +
            "         \"language\":{\n" +
            "            \"name\":\"it\",\n" +
            "            \"url\":\"https://pokeapi.co/api/v2/language/8/\"\n" +
            "         }\n" +
            "      },\n" +
            "      {\n" +
            "         \"genus\":\"Genetic Pokémon\",\n" +
            "         \"language\":{\n" +
            "            \"name\":\"en\",\n" +
            "            \"url\":\"https://pokeapi.co/api/v2/language/9/\"\n" +
            "         }\n" +
            "      },\n" +
            "      {\n" +
            "         \"genus\":\"いでんしポケモン\",\n" +
            "         \"language\":{\n" +
            "            \"name\":\"ja\",\n" +
            "            \"url\":\"https://pokeapi.co/api/v2/language/11/\"\n" +
            "         }\n" +
            "      },\n" +
            "      {\n" +
            "         \"genus\":\"基因宝可梦\",\n" +
            "         \"language\":{\n" +
            "            \"name\":\"zh-Hans\",\n" +
            "            \"url\":\"https://pokeapi.co/api/v2/language/12/\"\n" +
            "         }\n" +
            "      }\n" +
            "   ],\n" +
            "   \"generation\":{\n" +
            "      \"name\":\"generation-i\",\n" +
            "      \"url\":\"https://pokeapi.co/api/v2/generation/1/\"\n" +
            "   },\n" +
            "   \"growth_rate\":{\n" +
            "      \"name\":\"slow\",\n" +
            "      \"url\":\"https://pokeapi.co/api/v2/growth-rate/1/\"\n" +
            "   },\n" +
            "   \"habitat\":{\n" +
            "      \"name\":\"rare\",\n" +
            "      \"url\":\"https://pokeapi.co/api/v2/pokemon-habitat/5/\"\n" +
            "   },\n" +
            "   \"has_gender_differences\":false,\n" +
            "   \"hatch_counter\":120,\n" +
            "   \"id\":150,\n" +
            "   \"is_baby\":false,\n" +
            "   \"is_legendary\":true,\n" +
            "   \"is_mythical\":false,\n" +
            "   \"name\":\"mewtwo\",\n" +
            "   \"names\":[\n" +
            "      {\n" +
            "         \"language\":{\n" +
            "            \"name\":\"ja-Hrkt\",\n" +
            "            \"url\":\"https://pokeapi.co/api/v2/language/1/\"\n" +
            "         },\n" +
            "         \"name\":\"ミュウツー\"\n" +
            "      },\n" +
            "      {\n" +
            "         \"language\":{\n" +
            "            \"name\":\"roomaji\",\n" +
            "            \"url\":\"https://pokeapi.co/api/v2/language/2/\"\n" +
            "         },\n" +
            "         \"name\":\"Mewtwo\"\n" +
            "      },\n" +
            "      {\n" +
            "         \"language\":{\n" +
            "            \"name\":\"ko\",\n" +
            "            \"url\":\"https://pokeapi.co/api/v2/language/3/\"\n" +
            "         },\n" +
            "         \"name\":\"뮤츠\"\n" +
            "      },\n" +
            "      {\n" +
            "         \"language\":{\n" +
            "            \"name\":\"zh-Hant\",\n" +
            "            \"url\":\"https://pokeapi.co/api/v2/language/4/\"\n" +
            "         },\n" +
            "         \"name\":\"超夢\"\n" +
            "      },\n" +
            "      {\n" +
            "         \"language\":{\n" +
            "            \"name\":\"fr\",\n" +
            "            \"url\":\"https://pokeapi.co/api/v2/language/5/\"\n" +
            "         },\n" +
            "         \"name\":\"Mewtwo\"\n" +
            "      },\n" +
            "      {\n" +
            "         \"language\":{\n" +
            "            \"name\":\"de\",\n" +
            "            \"url\":\"https://pokeapi.co/api/v2/language/6/\"\n" +
            "         },\n" +
            "         \"name\":\"Mewtu\"\n" +
            "      },\n" +
            "      {\n" +
            "         \"language\":{\n" +
            "            \"name\":\"es\",\n" +
            "            \"url\":\"https://pokeapi.co/api/v2/language/7/\"\n" +
            "         },\n" +
            "         \"name\":\"Mewtwo\"\n" +
            "      },\n" +
            "      {\n" +
            "         \"language\":{\n" +
            "            \"name\":\"it\",\n" +
            "            \"url\":\"https://pokeapi.co/api/v2/language/8/\"\n" +
            "         },\n" +
            "         \"name\":\"Mewtwo\"\n" +
            "      },\n" +
            "      {\n" +
            "         \"language\":{\n" +
            "            \"name\":\"en\",\n" +
            "            \"url\":\"https://pokeapi.co/api/v2/language/9/\"\n" +
            "         },\n" +
            "         \"name\":\"Mewtwo\"\n" +
            "      },\n" +
            "      {\n" +
            "         \"language\":{\n" +
            "            \"name\":\"ja\",\n" +
            "            \"url\":\"https://pokeapi.co/api/v2/language/11/\"\n" +
            "         },\n" +
            "         \"name\":\"ミュウツー\"\n" +
            "      },\n" +
            "      {\n" +
            "         \"language\":{\n" +
            "            \"name\":\"zh-Hans\",\n" +
            "            \"url\":\"https://pokeapi.co/api/v2/language/12/\"\n" +
            "         },\n" +
            "         \"name\":\"超梦\"\n" +
            "      }\n" +
            "   ],\n" +
            "   \"order\":182,\n" +
            "   \"pal_park_encounters\":[\n" +
            "      {\n" +
            "         \"area\":{\n" +
            "            \"name\":\"field\",\n" +
            "            \"url\":\"https://pokeapi.co/api/v2/pal-park-area/2/\"\n" +
            "         },\n" +
            "         \"base_score\":90,\n" +
            "         \"rate\":3\n" +
            "      }\n" +
            "   ],\n" +
            "   \"pokedex_numbers\":[\n" +
            "      {\n" +
            "         \"entry_number\":150,\n" +
            "         \"pokedex\":{\n" +
            "            \"name\":\"national\",\n" +
            "            \"url\":\"https://pokeapi.co/api/v2/pokedex/1/\"\n" +
            "         }\n" +
            "      },\n" +
            "      {\n" +
            "         \"entry_number\":150,\n" +
            "         \"pokedex\":{\n" +
            "            \"name\":\"kanto\",\n" +
            "            \"url\":\"https://pokeapi.co/api/v2/pokedex/2/\"\n" +
            "         }\n" +
            "      },\n" +
            "      {\n" +
            "         \"entry_number\":249,\n" +
            "         \"pokedex\":{\n" +
            "            \"name\":\"original-johto\",\n" +
            "            \"url\":\"https://pokeapi.co/api/v2/pokedex/3/\"\n" +
            "         }\n" +
            "      },\n" +
            "      {\n" +
            "         \"entry_number\":254,\n" +
            "         \"pokedex\":{\n" +
            "            \"name\":\"updated-johto\",\n" +
            "            \"url\":\"https://pokeapi.co/api/v2/pokedex/7/\"\n" +
            "         }\n" +
            "      },\n" +
            "      {\n" +
            "         \"entry_number\":196,\n" +
            "         \"pokedex\":{\n" +
            "            \"name\":\"conquest-gallery\",\n" +
            "            \"url\":\"https://pokeapi.co/api/v2/pokedex/11/\"\n" +
            "         }\n" +
            "      },\n" +
            "      {\n" +
            "         \"entry_number\":151,\n" +
            "         \"pokedex\":{\n" +
            "            \"name\":\"kalos-mountain\",\n" +
            "            \"url\":\"https://pokeapi.co/api/v2/pokedex/14/\"\n" +
            "         }\n" +
            "      },\n" +
            "      {\n" +
            "         \"entry_number\":150,\n" +
            "         \"pokedex\":{\n" +
            "            \"name\":\"updated-kanto\",\n" +
            "            \"url\":\"https://pokeapi.co/api/v2/pokedex/26/\"\n" +
            "         }\n" +
            "      }\n" +
            "   ],\n" +
            "   \"shape\":{\n" +
            "      \"name\":\"upright\",\n" +
            "      \"url\":\"https://pokeapi.co/api/v2/pokemon-shape/6/\"\n" +
            "   },\n" +
            "   \"varieties\":[\n" +
            "      {\n" +
            "         \"is_default\":true,\n" +
            "         \"pokemon\":{\n" +
            "            \"name\":\"mewtwo\",\n" +
            "            \"url\":\"https://pokeapi.co/api/v2/pokemon/150/\"\n" +
            "         }\n" +
            "      },\n" +
            "      {\n" +
            "         \"is_default\":false,\n" +
            "         \"pokemon\":{\n" +
            "            \"name\":\"mewtwo-mega-x\",\n" +
            "            \"url\":\"https://pokeapi.co/api/v2/pokemon/10043/\"\n" +
            "         }\n" +
            "      },\n" +
            "      {\n" +
            "         \"is_default\":false,\n" +
            "         \"pokemon\":{\n" +
            "            \"name\":\"mewtwo-mega-y\",\n" +
            "            \"url\":\"https://pokeapi.co/api/v2/pokemon/10044/\"\n" +
            "         }\n" +
            "      }\n" +
            "   ]\n" +
            "}";
}
