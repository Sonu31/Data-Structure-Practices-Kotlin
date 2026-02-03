#[[
cmake_minimum_required(VERSION 3.10.2)

# Define the library name and source file(s)
add_library(native-lib SHARED native-lib.cpp)

# Link the native library to log (required by Android)
find_library(log-lib log)
set(CMAKE_CXX_FLAGS "${CMAKE_CXX_FLAGS} -std=c++11")
set(CMAKE_SHARED_LINKER_FLAGS "${CMAKE_SHARED_LINKER_FLAGS} -Wl,--exclude-libs,libc++_shared.so")
# Set C++ Standard
set(CMAKE_CXX_STANDARD 17)
set(CMAKE_CXX_STANDARD_REQUIRED ON)

# Link libraries to your native-lib
target_link_libraries(native-lib
        ${log-lib}
        c++_shared   # <-- Add this to fix the std::string linker issue
)]]


cmake_minimum_required(VERSION 3.10.2)
project("app")

add_library( # Creates a native library
        native-lib
        SHARED
        native-lib.cpp )

find_library( # Searches for the log library
        log-lib
        log )

target_link_libraries( # Links native library with log library
        native-lib
        ${log-lib} )