# LeadMentoringPetShopAplication
### O PetShop Lead tem como objetivo o gerenciamento de um Petshop, permitindo o cadastro de produtos e pets de cada petshop.

Desafio final do projeto Lead Mentoring.  
Mentor: <a href="https://github.com/CCastro01">Christian Castro</a>  


## Tech  
- Java  
- Spring Boot
- PostgreSQL  


## API Reference  
- [Produtos](#Produto-lead)
- [Pets](#Petshop-Lead)
  

## Petshops 
#### Get all Petshops
```http://localhost:8080/Petshop-Lead
  GET /Petshop-Lead/
```

| Parameter | Type     | Description                |
| :-------- | :------- | :------------------------- |
|  |  |  |

#### Get Petshop by ID

```http://localhost:8080/Petshop-Lead/{id}
  GET /Petshop-Lead/${id}
```

| Parameter | Type     | Description                       |
| :-------- | :------- | :-------------------------------- |
| `id`      | `UUID` | **Required**.    |


#### Post Petshops

```http://localhost:8080/Petshop-Lead
  POST /Petshop-Lead/
```

| Parameter | Type     | Description                |
| :-------- | :------- | :------------------------- |
| `PetShop` | `Object` | **Required**.  |

#### Put Petshops

```http://localhost:8080/Petshop-Lead
  PUT /Petshop-Lead/
```

| Parameter | Type     | Description                |
| :-------- | :------- | :------------------------- |
| `PetShop` | `Object` | **Required**.  |

#### Delete Petshop by ID

```http://localhost:8080/Petshop-Lead/{id}
  DELETE /Petshop-Lead/${id}
```

| Parameter | Type     | Description                       |
| :-------- | :------- | :-------------------------------- |
| `id`      | `UUID` | **Required**.  |


## Produtos  
#### Get all Products
```http://localhost:8080/Produto-Lead
  GET /Produto-Lead/
```

| Parameter | Type     | Description                |
| :-------- | :------- | :------------------------- |
|  |  |  |

#### Get Product by ID

```http://localhost:8080/Produto-Lead/{id}
  GET /Produto-Lead/${id}
```

| Parameter | Type     | Description                       |
| :-------- | :------- | :-------------------------------- |
| `id`      | `UUID` | **Required**.    |



#### Post Product

```http://localhost:8080/Produto-Lead
  POST /Produto-Lead
```

| Parameter | Type     | Description                |
| :-------- | :------- | :------------------------- |
| `Product` | `Object` | **Required**.  |

#### Put Petshops

```http://localhost:8080/Produto-Lead
  PUT /Produto-Lead/
```

| Parameter | Type     | Description                |
| :-------- | :------- | :------------------------- |
| `Product` | `Object` | **Required**.  |

#### Delete Product by ID

```http://localhost:8080/Produto-Lead/{id}
  DELETE /Produto-Lead/${id}
```

| Parameter | Type     | Description                       |
| :-------- | :------- | :-------------------------------- |
| `id`      | `UUID` | **Required**.  |  

