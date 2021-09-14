package cn.edu.tongji.software_igem2021.igemwebbackend.Entity;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Objects;

public class ScoreBugEntityPK implements Serializable {
    private String seqNcbiId;
    private String phageId;

    @Column(name = "seq_ncbi_id")
    @Id
    public String getSeqNcbiId() {
        return seqNcbiId;
    }

    public void setSeqNcbiId(String seqNcbiId) {
        this.seqNcbiId = seqNcbiId;
    }

    @Column(name = "phage_id")
    @Id
    public String getPhageId() {
        return phageId;
    }

    public void setPhageId(String phageId) {
        this.phageId = phageId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ScoreBugEntityPK that = (ScoreBugEntityPK) o;
        return Objects.equals(seqNcbiId, that.seqNcbiId) && Objects.equals(phageId, that.phageId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(seqNcbiId, phageId);
    }
}
