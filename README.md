# Recommend Product App

## Table of Contents

1. [Installation](#installation)
    * [Cloning repo and installation of dependencies](#cloning-repo-and-installation-of-dependencies)
2. [Endpoints](#endpoints)
    * [Recommend](#recommend)
        - [/api/recommend/](#/api/recommend/{userId})
   *  [Product View](#Product View)
       - [/api/product/](#/api/product/{userId})
       - [/api/product/](#/api/product/)

## Installation

#### Cloning repo and Installation of Dependencies
```
git clone https://github.com/furkandemirtrk/recommend-products-app.git
# or gh repo clone furkandemirtrk/recommend-products-app
```


## Endpoints

### Recommend
#### GET
#### /api/recommend/{userId}

##### Example Response Non-personalized

```
{
    "userId": "user-1000",
    "products": [
        "product-4",
        "product-123",
        "product-238",
        "product-293",
        "product-172",
        "product-189",
        "product-556",
        "product-116",
        "product-199",
        "product-6"
    ],
    "type": "non_personalized"
}
```

##### Example Response Personalized
```
{
    "userId": "user-78",
    "products": [
        "product-189",
        "product-556",
        "product-6",
        "product-50",
        "product-458",
        "product-105",
        "product-426",
        "product-38",
        "product-583",
        "product-424"
    ],
    "type": "personalized"
}
```


### Product View
##### GET
#### /api/product/{userId}

##### Example Response 

```
{
    "userId": "user-78",
    "products": [
        "product-173",
        "product-164"
    ],
    "type": "personalized"
}
```

##### DELETE
#### /api/product/

##### Example Request

```
{
    "userId" : "user-78",
    "productId" : "product-173"
}
```

##### Example Response

```
true or false
```
