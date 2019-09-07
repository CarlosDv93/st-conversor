# Conversor de vídeo

## Como usar?

Após subir o projeto é necessário fazer uma requisição POST para o local /converter/upload passando no body o arquivo. 


    {
        "file": "Arquivo"
    }


Após subir, o arquivo será enviado para um bucket do S3.
Automaticamente após o upload acontecer, será enviado a URL para o Bitmovin realizar o processamento do vídeo. 

O Retorno do POST é a URL onde fica salvo o arquivo Dash Manifest para poder enviar-lo para a página de exibição do vídeo no frontEnd. 

### Tecnologias Usadas

#### Front 
O Front foi desenvolvido em Angular (TypeScript) com suporte do Bootstrap. 

#### Backend
O backend foi desenvolvido usando Java com o framework Spring. 
Na parte das requisições que são feitas ao BITMOVIN foi utilizado o RestTemplate e o ObjectMapper em alguns casos para gerar o body das requisições necessárias. 


##### TO DO

Na branch master estará o projeto entregue até a data solicitada. 
Será criada um branch WIP na qual será continuado o desenvolvimento do projeto durante o final de semana. 
Houve alguns problemas com a conta da amazon inicial que acabou atrasando o desenvolvimento além do que gostaria.

  
