# Trip Planner API

## Trip Planner

The Trip Planner API is designed to facilitate planning and managing trips with comprehensive features including trip management, participant invitations, link management, activity scheduling, and accommodation booking. This report provides an overview of the API structure, endpoints, and security measures.

## API Information

- **Title**: Trip Planner API
- **Description**: This API allows users to manage trips, invite participants, manage links, schedule activities, and book accommodations.

## Microservices

The API is structured into five microservices:

1. **Trip Service**: Manages trip operations like creation, update, and retrieval of trip details.
2. **Participant Service**: Handles participant-related functionalities such as inviting participants and managing participant details.
3. **Link Service**: Manages external links, supporting creation, login, and deletion operations.
4. **Activity Service**: Manages activities available during trips, supporting creation, retrieval, and deletion of activities.
5. **Accommodation Service**: Facilitates accommodation bookings, providing endpoints for creation, retrieval, and deletion of accommodations.

## Endpoints

The API comprises various endpoints categorized into different tags based on functionality. Detailed specifications for each endpoint can be found in the YAML file included in the repository.

## Schemas

The API defines several data schemas (Trip, Participant, Link, Activity, Accommodation) outlining the structure and format of request and response payloads for each endpoint.
