# Projeto Final da matéria Sistemas Distribuidos.

instalar o docker e o docker-compose. https://docs.docker.com/compose/

executar "docker-compose up -d" na raiz do projeto.

endpoints da aplicação: 

Porta padrão para os veículos:
{
	Veículo1: "9000",
	Veículo2: "9001"
}


METODO: POST
http://52.67.118.147
:(porta veículo)/veiculo/informar_posicao
Mensagem gerada automaticamente a cada 5 segundos.

METODO: POST
http://52.67.118.147
:(porta veículo)/veiculo/mensagem_central
{
	"mensagem": "mensagem a ser enviada"
}

METODO: POST
http://52.67.118.147
:(porta veículo)/veiculo/mensagem_direta
{
	"mensagem": "mensagem a ser enviada",
	"destino": "id veículo destino"
}

METODO: POST
http://52.67.118.147
:(porta veículo)/veiculo/alerta
{
	"mensagem": "mensagem a ser enviada"
}


METODO: POST
http://52.67.118.147
:(porta veículo)/veiculo/parada
{
	"mensagem": "mensagem a ser enviada",
	"tempoParada": "10"
}


METODO: POST
http://52.67.118.147:8000/central/mensagem_direta

{
	"mensagem": "mensagem a ser enviada",
	"destino": "id veículo destino"
}


METODO: POST
http://52.67.118.147:8000/central/alerta
 
{
	"mensagem": "mensagem a ser enviada"
}

METODO: GET
http://52.67.118.147:8000/central/veiculos

{

}

METODO: GET
http://52.67.118.147:8000/actuator/logfile
 --central

http://52.67.118.147:9000/actuator/logfile
 --veiculo1

http://52.67.118.147:9001/actuator/logfile
 --veiculo2 
