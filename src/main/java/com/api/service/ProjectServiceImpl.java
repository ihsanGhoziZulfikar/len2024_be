package com.api.service;

import java.util.List;
import java.util.Optional;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.api.entity.LocationProject;
import com.api.entity.Project;
import com.api.repository.ProjectRepository;

@Service
public class ProjectServiceImpl implements ProjectService {
    // private List<Project> projectList;

    public ProjectServiceImpl(){
        // this.projectList = new ArrayList<>();
        // Project p1 = new Project(1, "nama 1", "client 1", LocalDateTime.now(), LocalDateTime.now(), "pimpinan 1", "keterangan 1", LocalDateTime.now());
        // Project p2 = new Project(2, "nama 2", "client 2", LocalDateTime.now(), LocalDateTime.now(), "pimpinan 2", "keterangan 2", LocalDateTime.now());
        // Project p3 = new Project(3, "nama 3", "client 3", LocalDateTime.now(), LocalDateTime.now(), "pimpinan 3", "keterangan 3", LocalDateTime.now());
        // this.projectList.addAll(Arrays.asList(p1, p2, p3));
    }

    @Autowired
    private ProjectRepository projectRepository;

    @Override
    public Project saveProject(Project project){
        if (project.getLokasiProyek() != null) {
        for (LocationProject lp : project.getLokasiProyek()) {
            lp.setProyek(project); 
        }
    }
        return projectRepository.save(project);
    }

    @Override
    public List<Project> fetchAllProjects(){
        List<Project> allProjects = projectRepository.findAll();
        return allProjects;
    }

    @Override
    public Project getProjectById(int id){
        // Optional<Project> project = projectRepository.findById(id);
        Optional<Project> project = Optional.ofNullable(projectRepository.findProyekWithLocations(id));
        if(project.isPresent()){
            return project.get();
        }
        return null;

        // for(Project project: projectList){
        //     if(project.getId() == id){
        //         return project;
        //     }
        // }
        // Project p = new Project(0, "not found", "client 1", LocalDateTime.now(), LocalDateTime.now(), "pimpinan 1", "keterangan 1", LocalDateTime.now());
        // return p;
    }
    @Override
    public Project updateProjectById(int id, Project project){
        Optional<Project> project1 = projectRepository.findById(id);

        if(project1.isPresent()){
            Project originalProject = project1.get();

            if(Objects.nonNull(project.getNamaProyek()) && !"".equalsIgnoreCase(project.getNamaProyek())){
                originalProject.setNamaProyek(project.getNamaProyek());
            }
            
            if(Objects.nonNull(project.getClient()) && !"".equalsIgnoreCase(project.getClient())){
                originalProject.setClient(project.getClient());
            }
            
            if(Objects.nonNull(project.getTglMulai())){
                originalProject.setTglMulai(project.getTglMulai());
            }
            
            if(Objects.nonNull(project.getTglSelesai())){
                originalProject.setTglSelesai(project.getTglSelesai());
            }
            
            if(Objects.nonNull(project.getPimpinanProyek()) && !"".equalsIgnoreCase(project.getPimpinanProyek())){
                originalProject.setPimpinanProyek(project.getPimpinanProyek());
            }
            
            if(Objects.nonNull(project.getKeterangan()) && !"".equalsIgnoreCase(project.getKeterangan())){
                originalProject.setKeterangan(project.getKeterangan());
            }
            
            if(Objects.nonNull(project.getCreatedAt())){
                originalProject.setCreatedAt(project.getCreatedAt());
            }
            
            return projectRepository.save(originalProject);
        }
        return null;
    }

    @Override
    public String deleteProjectById(int id){
        if(projectRepository.findById(id).isPresent()){
            projectRepository.deleteById(id);
            return "Project deleted successfully";
        }
        return "No such project in the database";
    }
}
