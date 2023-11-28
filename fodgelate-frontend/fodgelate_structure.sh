#!/bin/bash -e

cd src/app

# Create components
ng generate component about
ng generate component account
ng generate component cart
ng generate component checkout
ng generate component contact
ng generate component home
ng generate component info

# Create products module and its components
ng generate module products
cd products
ng generate component components/product-list
ng generate component containers/product-detail
ng generate component containers/product-search
cd ..

# Create shared module and its components
ng generate module shared
cd shared
ng generate component components/carousel
ng generate component components/confirmation-dialog
ng generate component components/error-dialog
ng generate component components/header
cd components/header
ng generate component icon-buttons
ng generate component logo
ng generate component mobile-menu
ng generate component navigation-menu
cd ../..

# Create services
cd ..
ng generate service cart/cart
cd products
ng generate service services/products
cd ..
cd shared/form
ng generate service form-utils
cd ../..

# Create model and pipe
touch products/model/product.ts
touch products/model/product.spec.ts
touch shared/pipes/category.pipe.ts
touch shared/pipes/category.pipe.spec.ts
