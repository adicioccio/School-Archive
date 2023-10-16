void printList() {
    Employee *ptr = head;

    if (head == NULL) {
        printf("List is empty.\n");
    }

    while(ptr != NULL) {
        printf("%s, %c, %d, %s \n",ptr->name, ptr->gender, ptr->age, ptr->job);
        ptr = ptr->next;
    }
	
}

int modify(char *element, int choice) {
    int count = 0;
    
    Employee *ptr = head;

    if (head == NULL){
        printf("List is empty.\n");
        return 0;
    }

    while(ptr != NULL) {
        if (strcmp(ptr->name, element) == 0) {
            if (choice == 1) {
                fflush(stdin);
                printf("Enter %s's new name.\n>", ptr->name);
                scanf("%20[^\n]s", eName);
                ptr->name = eName;
            
            } else if (choice == 2) {
                fflush(stdin);
                printf("Enter %s's new gender.\n>", ptr->name);
                eGender = getc(stdin);
                ptr->gender = eGender;
            
            } else if (choice == 3) {
                printf("Enter %s's new age.\n>", ptr->name);
                scanf("%d", &eAge);
                ptr->age = eAge;
            
            } else if (choice == 4) {
                fflush(stdin);
                printf("Enter %s's new job.\n>", ptr->name);
                scanf("%25[^\n]s", eJob);
                ptr->job = eJob;
            }

            return 1;
            
        }
        ptr = ptr->next;
    }
    printf("Not found.\n");
    return 0;
}

int delete(char *element) {
    Employee *current = head;
    Employee *previous = NULL;

    if (head == NULL){
        printf("List is empty.\n");
        return 0;
    }

    while(strcmp(current->name, element) != 0) {
        if(current->next == NULL) {
            printf("Not found.\n");
            return 0;
        } else {
            previous = current;
            current = current->next;
        }
    }

    if(current == head) {
        head = head->next;
    } else {
        previous->next = current->next;
    }
    return 1;
}

void insert(char *name, char gender, int age, char *job) {

    Employee *link = malloc(sizeof(Employee));

    link->name = malloc(sizeof(char) * MAX_NAME_LENGTH);
    link->job = malloc(sizeof(char) * MAX_JOB_LENGTH);

    strcpy(link->name, name);
    link->gender = gender;
    link->age = age;
    strcpy(link->job, job);

    link->next = head;

    head = link;
}

void printMenu() {
    printf("-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-\n");
    printf("[1] Insert an employee into the list. \n");
    printf("[2] Modify employee from the list. \n");
    printf("[3] Delete employee from the list. \n");
    printf("[4] Display employees from the list. \n");
    printf("[5] Exit the program. \n");
    printf("-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-\n");
}

int runProgram() {
    eName = malloc(sizeof(char) * MAX_NAME_LENGTH);
    eJob = malloc(sizeof(char) * MAX_NAME_LENGTH);
    
    /*
    insert("Adam Di Cioccio", 'M', 19, "Software Engineer");
    insert("Mike Zhigun", 'T', 17, "Statistics Canada");
    insert("John Doe", 'M', 19, "Academic Advisor");
    insert("Donald Duck", 'T', 17, "Mickey's Clubhouse");
    insert("Surbhi Bahri", 'F', 21, "Greatest teacher");
    */

    while (input != 5) {
        printMenu();
        printf(">");
        
        scanf("%d" ,&input);

        switch (input) {
            case 1:
                fflush(stdin);
                
                printf("Enter the employee's name.\n>");
                scanf("%20[^\n]s", eName);
                
                fflush(stdin);

                printf("Enter the employee's gender.\n>");
                eGender = getc(stdin);

                fflush(stdin);

                printf("Enter the employee's age.\n>");
                scanf("%d", &eAge);

                fflush(stdin);
                
                printf("Enter the employee's job.\n>");
                scanf("%25[^\n]s", eJob);

                insert(eName, eGender, eAge, eJob);
                
                fflush(stdin);
                break;
            case 2:
                fflush(stdin);
                
                printf("Enter the employee's name to modify.\n>");
                scanf("%20[^\n]s", eName);

                printf("What would you like to modify?\n1. Name\n2. Gender\n3. Age\n4. Job\n>");
                scanf("%d", &choice);
                
                modify(eName, choice);
                break;
            case 3:
                fflush(stdin);
                
                printf("Enter the employee's name to delete.\n>");
                scanf("%20[^\n]s", eName);
                
                delete(eName);
                break;
            case 4:
                fflush(stdin);
                printList();
                break;
            case 5:
                fflush(stdin);
                printf("Quitting program...");
                free(head);
                input = 5;
                break;
            default:   
                fflush(stdin);
                printf("Invalid input.\n");
                break;
        }
    }  
    return EXIT_SUCCESS;
}