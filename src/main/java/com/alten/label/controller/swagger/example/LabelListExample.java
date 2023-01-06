package com.alten.label.controller.swagger.example;

public class LabelListExample {

    public static final String LABEL_LIST_IMPORT = """
                    {
                    "id": 1675,
                    "name": "Label_list",
                    "metadata": {
                        "owner": "Guillaume DELBARRE",
                        "confidentiality": "C0",
                        "date": "2022-06-08T09:13:39+00:00"
                    },
                    "list_structure": "SIMPLE",
                    "list_elements":
                    [
                        {
                          "label_id": 1,
                          "label_content": "Oui",
                          "label_desc": "Je suis sûr qu'il s'agit des mêmes"
                        },
                        {
                          "label_id": 2,
                          "label_content": "Je pense que Oui",
                          "label_desc": "Je suis à peu prêt sûr qu'il s'agit des mêmes"
                        },
                        {
                          "label_id": 3,
                          "label_content": "Je ne sais pas",
                          "label_desc": "Je ne suis pas sûr qu'il s'agit des mêmes"
                        },
                        {
                          "label_id": 4,
                          "label_content": "Je pense que Non",
                          "label_desc": "Je suis à peu prêt sûr qu'il ne s'agit pas des mêmes"
                        },
                        {
                          "label_id": 5,
                          "label_content": "Non",
                          "label_desc": "Je suis sûr qu'il ne s'agit pas des mêmes"
                        }
                      ]
                    }
            """;

    public static final String LABEL_LIST_ELEMENT = """
            [
              {
                "label_id": "6",
                "label_content": "stefan",
                "label_desc": "stefan",
                "label_parents": [
                ]
              }
            ]
            """;

    public static final String LIST_ELEMENT_IMPORT = """
        {
                        "label_id": "1",
                        "label_content": "Oui",
                        "label_desc":"Je suis sûr qu'il s'agit des mêmes",
                        "label_parents":[{
                            "label_id": "2",
                            "label_content": "Je pense que Oui",
                            "label_desc": "Je suis à peu prêt sûr qu'il s'agit des mêmes"
                        }]
        }
        """;

    public static final String LABEL_LIST_UPDATE = """
                {
                  "label_content": "Oui, updated",
                  "label_desc": "Je suis sûr qu'il s'agit des mêmes, updated"
                }
            """;

    public static final String METADATA_EXAMPLE = """
                 {
                "owner": "ALTEN",

                "confidentiality": "C3",

                "language": "ro",

                "date": "2022-10-24T07:17:35+00:00"
            }
                   """;

    public static final String LABEL_LIST_UPDATE_PARENTS = """
                 [
                    {
                      "label_id": 2                
                    },                
                {
                      "label_id": 4               
                    }
                  ]
                
            """;

}
