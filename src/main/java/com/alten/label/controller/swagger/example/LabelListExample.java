package com.alten.label.controller.swagger.example;

public class LabelListExample {

    public static final String LABEL_LIST_IMPORT = """
                    {
                    "id": 1675,
                    "name": "Label_list",
                    "metadata": {
                        "owner": "Guillaume DELBARRE",
                        "confidentiality": "public",
                        "date": "2022-06-08T09:13:39+00:00"
                    },
                    "list_structure": "simple",
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

}
