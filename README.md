# architecture_components_demo
This is a demo project to show how architecure components and live data works. It's done in three loosely coupled layers, 
namely representation layer, the domain layer and data layer. Each layer has a definitely separate task in a as loose manner as
possible so that unit tests can be done without in each class without much mocking and other head aches. Applications designed 
this way are easily maintained and easy to understand for a new members of a team. 

The architecture components include viewmodels, data object(DAO), live data and room database. In this example I put the room database in the data layer and all the business logic(purely java without android references) in the domain layer and viewmodel in the presentation layer.The UI passes user provided data to the viewmodel, which is responsible for taking data from the UI and presnts data back as needed and doesn't know wnything that happens after that. 

The usecases receive the data from viewmodel and passes data to the repository and lets the repository access the roomdatabase and gets
data as needed and sends back to the usecase. The usecase sends the data back to the viewmodel. In this design each module just passes 
data to the layer under it using interfaces but has no knowledge how that layer uses that data. 

Architecture components use obseravable/observer pattern where the viewmodel will observe for data changes and roomdatabase provides 
any data if it's changed. The activity will alaways gets fresh data and there will no momory leak when the activity is gone because 
the viewmodel is life cycle aware and knows when to present the data. This fixes the activity state changes caused after user rotates 
the phone and the activity is killed and recreated by the system. 

Modules
The Core module contains all project wide utility classes.

Data layer 
This module contains the room database and the entity classes in a model package, cache package, and data object(DAO) class.

Domain layer
This module contains the business logic classes in a model package, usecase classes package, repository classes package and adpater
classes package to map objects from one layer to another.

Presentation layer
This model contains the UI classes, viewmodel classes, adapter classes to map objects from one module to another and the model classes.
