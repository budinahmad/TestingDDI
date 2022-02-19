# TestingDDI
Tes program DDI

- untuk page 1
Get data category
url = http://localhost:8080/api/category/getall
method GET

- untuk page 2
Get data item by categoryId
url = http://localhost:8080/api/item/getitembycategoryId
method POST
Parameter =
{
	"value":"1",
	"size":10,
	"page":0,
	"keysort":"id",
	"sort":"asc"
}

- untuk page ke 3
Get item by id
url = http://localhost:8080/api/item/findbyid
method POST
Paramter = 
{
	"value":"1",
	"size":0,
	"page":0,
	"keysort":"",
	"sort":""
}

- API pendukung 
Create data category
url = http://localhost:8080/api/category/create
method POST
Parameter = 	{		
			"id":3,
			"name":"EDUCATION",
			"gambar":"Gambar1base45"
	}

Create data item
url = http://localhost:8080/api/item/create
method POST
Parameter = 	{
		"name": "COMPANY F",
		"description": "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.",
		"gambar": "Gambar1base45",
		"category":{
			"id":1,
			"name":"COMPANY",
			"gambar":"Gambar1base45"
		}
	}
	
Dan masih ada yang lain nya seperti update dan delete
Terimakasih





