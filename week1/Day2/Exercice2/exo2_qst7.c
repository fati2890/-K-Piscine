#include <stdio.h>
#include <stdlib.h>
#include <pthread.h>
#include <unistd.h>

typedef struct {
    int id;
    int priority;
} ThreadData;

void* thread_function(void* arg) {
    ThreadData* data = (ThreadData*) arg;
    printf("Hello! Thread %d | Priority: %d | PID: %d\n", data->id, data->priority, getpid());
    return NULL;
}

int main(int argc, char* argv[]) {
    if (argc < 2) {
        fprintf(stderr, "Usage: %s <num_threads>\n", argv[0]);
        return 1;
    }

    int n = atoi(argv[1]);
    pthread_t threads[n];
    ThreadData data[n];

    for (int i = 0; i < n; i++) {
        data[i].id = i + 1;
        data[i].priority = 10 + i;  // Simulated priority
        pthread_create(&threads[i], NULL, thread_function, &data[i]);
    }

    for (int i = 0; i < n; i++) {
        pthread_join(threads[i], NULL);
    }

    return 0;
}
